package com.study.spring.core.springapplicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
/*
INFO : @SpringBootApplication 어노테이션을 살펴보면 내부에 ApplicationConfig 를 통해 설정해 주었던
       @Configuration 어노테이션과
       @@ComponentScan 어노테이션이 들어가 있음을 확인할수 있음
       즉 SpringBootApplication 어노테이션 사용시 ApplicationConfig 를 통해 설정하였던 설정을 그대로 사용 가능하다는 의미
*/
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        /* INFO : CLASS를 사용하는 방법 */
        //ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        /*INFO : XML을 사용하는 방법*/
        //ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //String[] beanDefinitionNames = context.getBeanDefinitionNames();
        //System.out.println(Arrays.toString(beanDefinitionNames));
        //BookService bookService = (BookService) context.getBean("bookService");
        //System.out.println(bookService.bookRepository != null);
    }

}
