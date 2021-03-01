package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //@Around("execution(* com.aop.EventService.*(..))") //INFO : com.aop.EventService 에 있는 모든 함수에 적용하라 (Point Cut 정의)
    //@Around("bean(simpleEventService)") // INFO : simpleEventService 빈을 사용하는곳에 적용
    @Around("@annotation(PerfLogging)")//@PerfLogging 이 붙어 있는곳에 하위 Advice 를 적용해라
    public Object logPerf(ProceedingJoinPoint pjp) throws  Throwable{//INFO : pjp 란 Advice 가 적용되는 범위
        long begin = System.currentTimeMillis(); //메소드 호출 이전
        Object retVal = pjp.proceed(); //메소드 호출
        System.out.println(System.currentTimeMillis() - begin); //메소드 호출 이후
        return retVal;
    }

    @Before("bean(simpleEventService)") //INFO : 메소드 실행 이전에 동작
    public void hello(){
        System.out.println("hello");
    }

}
