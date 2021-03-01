package com.java8;

public class Foo {

    public static void main(String[] args) {
        //익명 내부 클래스 (구버전 방식)
        /*RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello World");
                System.out.println("lamda");
            }
        };*/
        //함수형 인터페이스를 사용하는 람다식
        //RunSomething runSomething = () -> System.out.println("Hello World"); //한줄일 경우

        RunSomething runSomething = () -> {
            System.out.println("Hello World");
            System.out.println("lamda");
        };

        runSomething.doIt();//호출

        /*
        아래와 같은 코드는 문제가 되지는 않지만 (baseNumber 은 final 취급하여 값변경이 안됨)
        함수형 프로그래밍에 적절한 방식이라고는 할수 없다고 한다.
        int baseNumber = 10;
        CalcSomething calcSomething = number -> number + baseNumber;
        */
        CalcSomething calcSomething = number -> number + 10;

        System.out.println(calcSomething.doIt(1));
        System.out.println(calcSomething.doIt(1));
        System.out.println(calcSomething.doIt(1));

        System.out.println(calcSomething.doIt(2));
        System.out.println(calcSomething.doIt(2));
        System.out.println(calcSomething.doIt(2));
    }
}
