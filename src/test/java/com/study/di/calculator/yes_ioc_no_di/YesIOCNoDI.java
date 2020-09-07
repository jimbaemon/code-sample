package com.study.di.calculator.yes_ioc_no_di;

import com.study.di.calculator.yes_ioc_no_di.service.CalculationServiceNoDi;
import com.study.di.calculator.yes_ioc_no_di.service.Impl.AdditionNoDi;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class YesIOCNoDI {

    @Test
    public void calculatorTest(){
        CalculationServiceNoDi calculationService = new CalculationServiceNoDi(new AdditionNoDi()); // 그떄 그떄 변경

        Assertions.assertThat(calculationService.calculate(1, 3))
                .isEqualTo(3);

        System.out.println(calculationService.calculate(1, 3));
    }
}
