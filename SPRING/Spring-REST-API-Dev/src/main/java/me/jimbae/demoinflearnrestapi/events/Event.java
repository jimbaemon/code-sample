package me.jimbae.demoinflearnrestapi.events;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import me.jimbae.demoinflearnrestapi.accounts.Account;
import me.jimbae.demoinflearnrestapi.accounts.AccountSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder @EqualsAndHashCode(of = "id")
@Entity
public class Event {
    @Id @GeneratedValue
    private int id;
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
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class)
    private Account manager;


    public void update() {
        //Update Free
        if(this.basePrice == 0 && this.maxPrice == 0){
            this.free = true;
        } else{
            this.free = false;
        }

        //Update Offline
        if(this.location == null || this.location.isEmpty()){
            this.offline = false;
        }else{
            this.offline = true;
        }
    }
}
