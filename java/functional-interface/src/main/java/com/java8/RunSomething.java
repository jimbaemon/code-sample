package com.java8;

//추상형 함수를 선언 (추상형 함수가 2개가 되면 빌드시 에러 발생)
@FunctionalInterface
public interface RunSomething {

    /*
    interface 에 하나의 함수만 존재한다면 함수형 인터페이스라 한다.
    아래와 같이 static default 등으로 구성된 함수가 존재 하더라도
    추상 함수가 하나만 존재한다면 함수형 인터페이스 (함수형 인터페이스는 람다식에서 쓰인다)
     */
    void doIt();

    //java8 부터 인터페이스에 static 함수를 구현할수 있다.
    static void printName(){
        System.out.println("test");
    }

    //default 형태의 메서드를 구할수 있다.
    default void printAge(){
        System.out.println("28");
    }
}
