package com.study.di.calculator.config;

import com.study.di.calculator.yes_di.service.Calculator;
import com.study.di.calculator.yes_di.service.Impl.Addition;
import com.study.di.calculator.yes_ioc_no_di.service.CalculationServiceNoDi;
import com.study.di.calculator.yes_ioc_no_di.service.CalculatorNoDi;
import com.study.di.calculator.yes_ioc_no_di.service.Impl.AdditionNoDi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CalculatorNoDi calculator(){
        return new AdditionNoDi(); //덧셈용
    }

    @Bean
    public CalculationServiceNoDi calculationServiceNoDi(){
        return new CalculationServiceNoDi(calculator());
    }





}
