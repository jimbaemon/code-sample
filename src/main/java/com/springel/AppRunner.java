package com.springel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    //INFO : 계산식 가능
    @Value("#{1 + 1}")
    int value;

    //INFO : 문자열 합치기 가능
    @Value("#{'hello' + 'world'}")
    String greeting;

    //INFO : 비교문 사용 가능
    @Value("#{ 1 eq 1}")
    boolean trueOrFalse;

    //INFO : 그냥 값을 집어넣어도 동작은 잘된다 (무의미해서 그렇지)
    @Value("hello")
    String hello;

    /*INFO : $ 는 property 를 사용하는것
             # 는 표현식을 사용하는것

    */ 
    @Value("${my.value}")
    int myValue;

    // INFO : 표현식(#) 안에서는 프로퍼티($)사용이 가능하나 반대는 안된다
    @Value("#{${my.value} eq 100}")
    boolean isMyValue100;

    // INFO : 빈에 있는 변수도 가져올수 있다.
    @Value("#{sample.data}")
    int sampleData;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=================");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(hello);
        System.out.println(myValue);
        System.out.println(isMyValue100);
        System.out.println(sampleData);

        /*
            INFO : 위에 사용하였던 @Value("#{}") 를 직접 구현하는것
        */
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2 + 100");
        Integer value = expression.getValue(Integer.class); // 자동 컨버전
        System.out.println(value);
    }
}
