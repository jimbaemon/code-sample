package scope.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRuner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    Single single;

    @Autowired
    Proto proto;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("proto");
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));

        System.out.println("single");
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));

        /*
        * INFO : Prototype Socpe 어노테이션 사용시 메번 인스턴스가 변경되어야 하나
        * Single 컴포넌트의 경우 구동시 인스턴스가 주입되므로
        * 인스턴스가 하나로 고정된다 (목적과 불일치)
        */
        System.out.println("proto by single");

        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());

    }
}
