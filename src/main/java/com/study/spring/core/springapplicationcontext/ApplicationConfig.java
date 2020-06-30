package com.study.spring.core.springapplicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//INFO : 스캔할위치 직접 지정@ComponentScan(basePackages = "com.study.spring.core.springapplicationcontext")
//@ComponentScan(basePackageClasses = DemoApplication.class) // INFO : 해당 클래스 지점 부터 스캐닝 시작
public class ApplicationConfig {
    /*
    INFO : Bean 을 일일이 등록해주는 방식
    @Bean
    public BookRepository bookRepository(){
        return new BookRepository();
    }

    @Bean
    public BookService bookService(){
        *//*
        INFO : 의존성 직접 주입 방식
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository());
        return bookService;*//*
        
        *//*INFO : BookService 에서 Autowired 어노테이션을 이용하여 주입 방식*//*
        return new BookService();
    }
    */
}
