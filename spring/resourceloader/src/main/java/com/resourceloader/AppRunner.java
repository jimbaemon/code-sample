package com.resourceloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {

    
    
    /*@Autowired
    ResourceLoader resourceLoader;*/

    @Autowired
    ApplicationContext resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(resourceLoader.getClass());
        
        /*
        * INFO : Resource 는 ApllicationContext에 따라 타입이 결정된다
        *        1.ClassPathXmlApplicationContext = ClassPathResource
        *        2.FileSystemXmlApplicationContext = FileSystemResource
        *        3.ServletContextResource = ServletContextResource
        * 
        *        *아래의 경우 Annotation 으로 ApplicationContext 를 생성하므로 AnnotationConfigServletWebServerApplicationContext
        *         상속자를 따라가다 보면 ServletContextResource 가 나오므로 ServletContextReosource 이다
        *
        *       강제로 Resource 타입을 정해주고 싶을경우 접두어를 사용하면 된다
        *       1.classpath: -> ClassPathResource
        *       2.file:/// -> FileSystemResource
        *       3.그외 -> ServletContextResource
        */
        Resource resource = resourceLoader.getResource("test.txt");
        System.out.println(resource.getClass());
        System.out.println(resource.exists());
        System.out.println(resource.getDescription()); // 파일 설명
        System.out.println(Files.readString(Path.of(resource.getURI()))); //파일 읽어오기 jdk 11 부터
    }
}
