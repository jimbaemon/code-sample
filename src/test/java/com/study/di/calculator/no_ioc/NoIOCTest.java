package com.study.di.calculator.no_ioc;

import com.study.di.calculator.no_ioc.service.AdditionNoIoc;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoIOCTest {

    @Test
    public void calculatorTest(){
        AdditionNoIoc addition = new AdditionNoIoc();

        Assertions.assertThat(addition.calculate(1, 2))
                .isEqualTo(3);
    }
}
