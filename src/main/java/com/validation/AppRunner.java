package com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator);

        Event event = new Event();
        event.setLimit(-1);
        event.setEmail("test");
        //EventValidator eventValidator = new EventValidator(); //INFO : SpringBoot 2.0 이전 방식
        Errors errors = new BeanPropertyBindingResult(event, "event");

        //eventValidator.validate(event, errors);

        validator.validate(event, errors); //INFO : annotation 을 통한 validating 가능

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("======== Error Codes ========" );
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
            System.out.println(e.getCode());
        });
    }
}
