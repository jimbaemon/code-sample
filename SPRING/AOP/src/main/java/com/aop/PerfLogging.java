package com.aop;

import java.lang.annotation.*;

/*
* 이 어노테이션을 사용하면 성능을 로깅해 줌 (주석으로 어노테이션을 설명하면 좋다)
* */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS) //INFO : 어노테이션 정보를 언제까지 유지하겟냐 (RetentionPolicy.CLASS{default} : CLASS로 컴파일 되도 포함된다)(RetentionPolicy.SOURCE 컴파일되면 사라짐)
public @interface PerfLogging {
}
