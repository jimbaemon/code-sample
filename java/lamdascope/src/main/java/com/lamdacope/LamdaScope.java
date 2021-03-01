package com.lamdacope;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LamdaScope {
    public static void main(String[] args) {
        LamdaScope foo = new LamdaScope();
        foo.run();
    }

    private void run() {
        int baseNumber = 10; //java8 부터는 자동 final 처리 된다

        /*
        * INFO : 내부 클래스, 익명 클래스에서는 
        * 같은 변수명으로 선언시 Scope(영역이) 다르기 때문에 내부 클래스의 변수로 shadowing 처리 된다
        */
        class LocalClass{
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }
        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 12;
                System.out.println(baseNumber);
            }
        };

        // INFO : 람다식 사용시 Scope 를 공유 하기 때문에 같은 변수명 선언시 에러 발생
        IntConsumer printInt = (i) /*(baseNumber)이것도 에러 난다*/ -> {
            //int baseNumber = 13; 에러가 난다
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
        
        /*INFO : JAVA8 에서는 변수를 final 목적으로 사용시 자동으로 변수가 final 처리가 되는데 해당 변수를 ++ 로 증가시켜줬기 때문에 final 처리가 풀리면서 에러 발생*/
        //baseNumber++; 에러 발생

    }
}
