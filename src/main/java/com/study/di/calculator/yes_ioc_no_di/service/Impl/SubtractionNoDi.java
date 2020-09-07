package com.study.di.calculator.yes_ioc_no_di.service.Impl;

import com.study.di.calculator.yes_ioc_no_di.service.CalculatorNoDi;

public class SubtractionNoDi implements CalculatorNoDi {

    public int calculate(int num1, int num2){
        return num1 - num2;
    }

}
