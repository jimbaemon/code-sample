package com.databinding;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //INFO : Converter 사용시
        //registry.addConverter(new EventConverter.StringToEventConverter());
        
        //INFO : Formatter 사용시
        registry.addFormatter(new EventFormatter());
    }
}
