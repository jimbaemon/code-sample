package com.study.di.calculator;

import com.study.di.calculator.no_ioc.service.AdditionNoIoc;
import com.study.di.calculator.no_ioc.service.SubtractionNoIoc;
import com.study.di.calculator.yes_di.service.Calculator;
import com.study.di.calculator.yes_di.service.Impl.Addition;
import com.study.di.calculator.yes_di.service.Impl.Subtraction;
import com.study.di.calculator.yes_ioc_no_di.service.CalculationServiceNoDi;
import com.study.di.calculator.yes_ioc_no_di.service.Impl.AdditionNoDi;
import com.study.di.calculator.yes_ioc_no_di.service.Impl.SubtractionNoDi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CalculationController {

    @Qualifier("substraction")
    @Autowired
    private Calculator calculator;

    @Autowired
    private CalculationServiceNoDi calculationServiceNoDi;

    /**
     * 결합도 높고 수정사항 많음
     */
    @GetMapping("no_ioc_no_di")
    @ResponseBody
    public int noIOCNoDI(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        SubtractionNoIoc subtraction = new SubtractionNoIoc(); //빼기?

        return subtraction.calculate(num1, num2);
    }


    /**
     * 결합도는 낮춰졌으나 메모리는 지속적으로 할당
     */
    @GetMapping("yes_ioc_no_di")
    @ResponseBody
    public int yesIocNoDI(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        CalculationServiceNoDi calculationServiceNoDi = new CalculationServiceNoDi(new SubtractionNoDi()); //뺼샘

        //new AddtionNoDi 를 통해 계속 생성해주므로 메모리 낭비 심함
        System.out.println(calculationServiceNoDi.getCalculator());

        return calculationServiceNoDi.calculate(num1, num2); //계산해라
    }

    @GetMapping("yesDI")
    @ResponseBody
    public  int yesDI(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        System.out.println(calculator);

        return calculator.calculate(num1, num2); // 계산해라
    }

    @GetMapping("yesDI2")
    @ResponseBody
    public  int yesDI2(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        System.out.println(calculationServiceNoDi);

        return calculationServiceNoDi.calculate(num1, num2);  // 계산해라
    }

}
