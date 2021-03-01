package com.study.di.calculator.yes_di.service.Impl;

import com.study.di.calculator.yes_di.service.Calculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("addition")
public class Addition implements Calculator {


    public int calculate(int num1, int num2){
        return num1 + num2;
    }

}
