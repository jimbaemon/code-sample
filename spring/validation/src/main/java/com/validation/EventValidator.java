package com.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    /*
    * INFO : 첫번째 구현체인 supports 에서는 해당 Validator 가 어느 Class 를 validating 해야하는지 지정 
    */
    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    /*
    * INFO : 두번째 구현체인 validate 에서는 validating 할 항목 지정
    */
    @Override
    public void validate(Object o, Errors errors) {
        // INFO : 빈값 확인
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is not allowed.");
    }
}
