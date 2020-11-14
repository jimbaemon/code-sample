package me.jimbae.demoinflearnrestapi.events;

import me.jimbae.demoinflearnrestapi.accounts.Account;
import me.jimbae.demoinflearnrestapi.accounts.AccountRespository;
import me.jimbae.demoinflearnrestapi.accounts.AccountRole;
import me.jimbae.demoinflearnrestapi.accounts.AccountService;
import me.jimbae.demoinflearnrestapi.common.AppProperties;
import me.jimbae.demoinflearnrestapi.common.BaseTest;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.oauth2.common.util.Jackson2JsonParser;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.IntStream;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EventControllerTest extends BaseTest {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRespository accountRespository;

    @Autowired
    AppProperties appProperties;

    @BeforeEach
    public void setUp(){
        this.eventRepository.deleteAll();
        this.accountRespository.deleteAll();
    }

    private String getBearerToken() throws Exception {
        return "Bearer" + getAuthToken(true);
    }

    private String getBearerToken(boolean needToCreateAccount) throws Exception {
        return "Bearer" + getAuthToken(needToCreateAccount);
    }

    public String getAuthToken(boolean needToCreateAccount) throws Exception {
        //Given
        if(needToCreateAccount) {
            createAccount();
        }

        ResultActions perform = this.mockMvc.perform(post("/oauth/token")
                .with(httpBasic(appProperties.getClientId(), appProperties.getClientSecret()))
                .param("username", appProperties.getUserUsername())
                .param("password", appProperties.getUserPassword())
                .param("grant_type", "password")
        );

        MockHttpServletResponse response = perform.andReturn().getResponse();
        String responseBody = response.getContentAsString();
        Jackson2JsonParser parser = new Jackson2JsonParser();
        return parser.parseMap(responseBody).get("access_token").toString();
    }

    private Account createAccount() {
        Account jimbae =  Account.builder()
                .email(appProperties.getUserUsername())
                .password(appProperties.getUserPassword())
                .roles(Set.of(AccountRole.USER, AccountRole.ADMIN))
                .build();
        return this.accountService.saveAccount(jimbae);
    }

    @Test
    @DisplayName("정상적으로 이벤트를 생성하는 테스트")
    public void createEvent() throws Exception {
        EventDto event = EventDto.builder()
                .name("REST API Development with Spring")
                .description("설명이 없네")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 25, 14, 21))
                .endEventDateTime(LocalDateTime.of(2018, 11, 26, 14, 21))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .build();

        //Mockito.when(eventRepository.save(event)).thenReturn(event);

        mockMvc.perform(post("/api/events/")
                    .header(HttpHeaders.AUTHORIZATION, getBearerToken())
                    .contentType(MediaType.APPLICATION_JSON) //해더설정
                    .accept(MediaTypes.HAL_JSON) //해더설정
                    .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists())
                .andExpect(header().exists(HttpHeaders.LOCATION))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
                .andExpect(jsonPath("id").value(Matchers.not(100)))
                .andExpect(jsonPath("free").value(false))
                .andExpect(jsonPath("offline").value(true))
                .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))
                //HATEOS 추가
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.query-events").exists())
                .andExpect(jsonPath("_links.update-event").exists())
                //Self Descriptive
                .andExpect(jsonPath("_links.profile").exists())
                //REST DOCS 추가 나오는 파라미터에 대한 설명이 없을시 에러가 난다.
                .andDo(document("create-event",
                        //링크 문서화
                        links(
                            linkWithRel("self").description("link to self"),
                            linkWithRel("query-events").description("link to query events"),
                            linkWithRel("update-event").description("link to update an existing event"),
                            linkWithRel("profile").description("link to update an existing event")
                        ),
                        //request 헤더 문서화
                        requestHeaders(
                            headerWithName(HttpHeaders.ACCEPT).description("accept header"),
                            headerWithName(HttpHeaders.CONTENT_TYPE).description("content type header")
                        ),
                        //request 변수 문서화
                        requestFields(
                                fieldWithPath("name").description("Name of new event"),
                                fieldWithPath("description").description("description of new event"),
                                fieldWithPath("beginEnrollmentDateTime").description("등록 시작일시"),
                                fieldWithPath("closeEnrollmentDateTime").description("등록 마감일시"),
                                fieldWithPath("beginEventDateTime").description("이벤트 시작일시"),
                                fieldWithPath("endEventDateTime").description("이벤트 종료일시"),
                                fieldWithPath("location").description("이게 없으면 온라인 모임"),
                                fieldWithPath("basePrice").description("참가비"),
                                fieldWithPath("maxPrice").description("경매비 0이면 무료 or 무제한"),
                                fieldWithPath("limitOfEnrollment").description("등록 제한")
                        ),
                        //response header 명시
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location header"),
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content Type")
                        ),
                        //응답 필드에 대한 문서화
                        relaxedResponseFields( // relaxedResponseFields : 문서 일부분만 테스트 가능하도록 하는 함수 (단점 : 검증이 안됨)
                                fieldWithPath("id").description("identifier of new event"),
                                fieldWithPath("name").description("Name of new event"),
                                fieldWithPath("description").description("description of new event"),
                                fieldWithPath("beginEnrollmentDateTime").description("등록 시작일시"),
                                fieldWithPath("closeEnrollmentDateTime").description("등록 마감일시"),
                                fieldWithPath("beginEventDateTime").description("이벤트 시작일시"),
                                fieldWithPath("endEventDateTime").description("이벤트 종료일시"),
                                fieldWithPath("location").description("이게 없으면 온라인 모임"),
                                fieldWithPath("basePrice").description("참가비"),
                                fieldWithPath("maxPrice").description("경매비 0이면 무료 or 무제한"),
                                fieldWithPath("limitOfEnrollment").description("등록 제한"),
                                fieldWithPath("free").description("무료 여부"),
                                fieldWithPath("offline").description("오프라인 여부"),
                                fieldWithPath("eventStatus").description("event status"),
                                fieldWithPath("manager").description("매니저"),
                                fieldWithPath("manager").description("매니저"),
                                fieldWithPath("_links.self.href").description("link to self"),
                                fieldWithPath("_links.query-events.href").description("link to query events"),
                                fieldWithPath("_links.update-event.href").description("link to update existing event"),
                                fieldWithPath("_links.profile.href").description("link to profile")
                        )
                ))
        ;
    }



    @Test
    @DisplayName("입력 받을 수 없는 값을 사용한 경우에 에러가 발생하는 테스트")
    public void createEvent_Bad_Request() throws Exception {
        Event event = Event.builder()
                .id(100)
                .name("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 25, 14, 21))
                .endEventDateTime(LocalDateTime.of(2018, 11, 26, 14, 21))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .free(true)
                .offline(false)
                .eventStatus(EventStatus.PUBLISHED)
                .build();

        mockMvc.perform(post("/api/events/")
                    .header(HttpHeaders.AUTHORIZATION, getBearerToken())
                    .contentType(MediaType.APPLICATION_JSON) //해더설정
                    .accept(MediaTypes.HAL_JSON) //해더설정
                    .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    @DisplayName("입력 값이 비어있는 경우에 에러가 발생하는 테스트")
    public void createEvent_Bad_Request_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder().build();

        mockMvc.perform(post("/api/events/")
                    .header(HttpHeaders.AUTHORIZATION, getBearerToken())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(this.objectMapper.writeValueAsString(eventDto)))
                .andExpect(status().isBadRequest())
        ;
    }
    @Test
    @DisplayName("입력 값이 잘못된 경우에 에러가 발생하는 테스트")
    public void createEvent_Bad_Request_Wrong_Input() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("REST API Development with Spring")
                .description("너 어디갔냐 ? ")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 24, 14, 21))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 27, 14, 21))
                .endEventDateTime(LocalDateTime.of(2018, 11, 21, 14, 21))
                .basePrice(1000)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .build();

        mockMvc.perform(post("/api/events/")
                    .header(HttpHeaders.AUTHORIZATION, getBearerToken())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(this.objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("content[0].objectName").exists())
                .andExpect(jsonPath("content[0].defaultMessage").exists())
                .andExpect(jsonPath("content[0].code").exists())
                .andExpect(jsonPath("_links.index").exists())
        ;
    }



    @Test
    @DisplayName("30개의 이벤트를 10개씩 두번째 페이지 조회하기")
    public void queryEvents() throws Exception{
        //Given
        IntStream.range(0, 30).forEach(this::generateEvnet);

        //When & THEN
        this.mockMvc.perform(get("/api/events")
                .param("page", "1")
                .param("size", "10")
                .param("sort", "name,DESC")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.eventList[0]._links.self").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.profile").exists())
                .andDo(document("query-events"))
        ;
    }

    @Test
    @DisplayName("30개의 이벤트를 10개씩 두번째 페이지 조회하기")
    public void queryEventsWithAuthentication() throws Exception{
        //Given
        IntStream.range(0, 30).forEach(this::generateEvnet);

        //When & THEN
        this.mockMvc.perform(get("/api/events")
                .header(HttpHeaders.AUTHORIZATION, getBearerToken()) //인증정보 추가시
                .param("page", "1")
                .param("size", "10")
                .param("sort", "name,DESC")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.eventList[0]._links.self").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.profile").exists())
                .andExpect(jsonPath("_links.create-event").exists()) //등록 링크 추가
                .andDo(document("query-events"))
        ;
    }

    @Test
    @DisplayName("기존의 이벤트를 하나 조회하기")
    public void getEvent() throws Exception{
        Account account = createAccount();

        //Given
        Event event = this.generateEvnet(100, account);

        //When & THEN
        this.mockMvc.perform(get("/api/events/{id}", event.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").exists())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.profile").exists())
                .andDo(document("get-an-event"))
        ;
    }

    @Test
    @DisplayName("없는 이벤트 조회시 404 에러 발생")
    public void getEvent404() throws Exception{
        //When & THEN
        this.mockMvc.perform(get("/api/events/11004"))
                .andExpect(status().isNotFound())
        ;
    }

    @Test
    @DisplayName("정상적으로 수정한 경우")
    public void updateEvent() throws Exception {
        //Given
        Account account = createAccount();

        Event event = this.generateEvnet(100, account);

        EventDto eventDto = modelMapper.map(event, EventDto.class);
        eventDto.setName("업데이트");

        this.mockMvc.perform(put("/api/events/{id}", event.getId())
                        .header(HttpHeaders.AUTHORIZATION, getBearerToken(false))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(eventDto))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("업데이트"))
                .andExpect(jsonPath("id").value(event.getId()))
        ;
    }

    @Test
    @DisplayName("입력값이 없는 경우 에러 발생")
    public void updateEvent400Empty() throws Exception {
        Event event = this.generateEvnet(100);

        EventDto eventDto = new EventDto();

        this.mockMvc.perform(put("/api/events/{id}", event.getId())
                        .header(HttpHeaders.AUTHORIZATION, getBearerToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(eventDto))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    @DisplayName("입력값이 잘못된 경우 에러 발생")
    public void updateEvent400Wrong() throws Exception {
        Event event = this.generateEvnet(100);

        EventDto eventDto = modelMapper.map(event, EventDto.class);
        eventDto.setBasePrice(20000);
        eventDto.setMaxPrice(10000);

        this.mockMvc.perform(put("/api/events/{id}", event.getId())
                        .header(HttpHeaders.AUTHORIZATION, getBearerToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(eventDto))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    @DisplayName("수정하려는 이벤트가 없는 경우 404 Not Found")
    public void updateEvent404() throws Exception {

        Account account = createAccount();
        this.accountRespository.save(account);

        Event event = this.generateEvnet(100, account);

        EventDto eventDto = new EventDto();
        eventDto.setName("업데이트");

        this.mockMvc.perform(patch("/api/event/{id}", "32412", eventDto).header(HttpHeaders.AUTHORIZATION, getBearerToken(false)))
                .andExpect(status().isNotFound())
        ;
    }

    @Test
    @DisplayName("권한이 불충분한 경우")
    public void updateEvent403() throws Exception {

    }

    private Event generateEvnet(int i) {
        return generateEvnet(i, null);
    }

    private Event generateEvnet(int i, Account account) {

        Event event = Event.builder()
                .name("event"+i)
                .description("test Event")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 25, 14, 21))
                .endEventDateTime(LocalDateTime.of(2018, 11, 26, 14, 21))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .manager(account)
                .free(false)
                .offline(true)
                .eventStatus(EventStatus.DRAFT)
                .build();

        return this.eventRepository.save(event);

    }

}
