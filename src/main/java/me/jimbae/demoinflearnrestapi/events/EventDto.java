package me.jimbae.demoinflearnrestapi.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EventDto {

    private String name; //이름
    private String description; //설명
    private LocalDateTime beginEnrollmentDateTime; //등록시작일시
    private LocalDateTime closeEnrollmentDateTime; //등록마감일시
    private LocalDateTime beginEventDateTime; //이벤트 시작일시
    private LocalDateTime endEventDateTime; //이벤트 종료일시
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional) //참가비
    private int maxPrice; // (optional) // 경매비 0이면 무료 or 무제한
    private int limitOfEnrollment; //등록 제한

}
