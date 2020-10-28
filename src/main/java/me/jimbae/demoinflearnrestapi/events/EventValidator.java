package me.jimbae.demoinflearnrestapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors){
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0){
            errors.rejectValue("basePrice", "wrongValue", "BasePrice 는 MaxPrice 보다 높을수 없습니다.");
            errors.rejectValue("maxPrice", "wrongValue", "MaxPrice 는 BasePrice 보다 낮을수 없습니다.");
        }
        
        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if(endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime()) ||
            endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
            endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())
        ){
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime 값이 잘못 되었습니다.");
        }
        
        //TODO 기타 검증
    }

}
