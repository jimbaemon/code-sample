package com.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Primary //INFO : AppRunner 에서 EventService 상속시 이 클래스를 상속받을 수 있게끔 primary 어노테이션 추가
//@Service
public class ProxySimpleEventService implements EventService{

    /*
    * INFO : Proxy 의 역활은 delegation(위임)
    *        위임으로 인해 실코드를 건들일 이유는 없어졌지만
    *        프록시를 지속적으로 생성해줘야 하는 문제와 함수별로 적용해 줘야 한다는 점은 유지된다
    *        이러한 점을 해결하는 방법으로 spring AOP 사용 가능
    * */

    @Autowired
    SimpleEventService simpleEventService;

    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.createEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.publishEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
    }
}
