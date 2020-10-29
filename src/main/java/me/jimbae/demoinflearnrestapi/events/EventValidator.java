package me.jimbae.demoinflearnrestapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors){
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0){
            errors.reject("wrongPrice", "가격을 잘못 입력 하였습니다.");
        }
        
        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if(endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime()) ||
            endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
            endEventDateTime.isBefore(eventDto.getBeginEventDateTime())
        ){
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime 값이 잘못 되었습니다.");
        }
        
        //TODO 기타 검증
    }

}
