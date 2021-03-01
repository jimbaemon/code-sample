package com.databinding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//INFO : 웹과 관련된 테스트만 진행되는 테스트 (거의 Controller 위주 이므로 사용할 클래스를 직접 설정해 줄수도 있음) 컴포넌트에 등록된 클래스만 사용 가능하다
@WebMvcTest({EventFormatter.class, EventController.class})
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("/event/1")) //INFO : Get 방식으로 요청
                .andExpect(status().isOk()) //INFO : 상태코드가 200 인가
                .andExpect(content().string("1"));
    }

}