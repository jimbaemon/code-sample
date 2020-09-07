package com.study.di.calculator.yes_ioc_no_di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class CalculationServiceNoDi {

    private CalculatorNoDi calculator;

    //생성자
    public CalculationServiceNoDi(CalculatorNoDi calculator) {
        this.calculator = calculator;
    }

    public CalculatorNoDi getCalculator(){
        return calculator;
    }

    public int calculate(int num1, int num2){
        return calculator.calculate(num1, num2);
    }
}
