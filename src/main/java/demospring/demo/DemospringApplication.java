package demospring.demo;

import demospring.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class DemospringApplication {

    @Autowired
    MyService myService;

    public static void main(String[] args) {
        //SpringApplication.run(DemospringApplication.class, args);
        var app = new SpringApplication(DemospringApplication.class);
        app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
            /*
            INFO : @SpringBootAplication 어노테이션의 경우 해당 어노테이션이 붙어있는 클래스와 하위 디렉터리에 등록된 컴포넌트만 등록한다
                   그러므로 demospring.out 패키지에 있는 MyService 는 컴포넌트 스캔이 안됨
                   그럴경우 아래와 같이 직접적으로 빈을 등록하여 사용할수 있다. (커스터마이징 할수 있음)
            */
            ctx.registerBean(MyService.class); 
            ctx.registerBean(ApplicationRunner.class, () -> sup -> System.out.println("Functional Bean Definition;"));
        });
        app.run(args);
    }

}
