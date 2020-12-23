package com.example.demo.service;

import com.example.demo.mapper.MybatisTestMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class exceptionTestService {

    private MybatisTestMapper mybatisTestMapper;

    @Autowired
    exceptionTestService(MybatisTestMapper mybatisTestMapper){
        this.mybatisTestMapper = mybatisTestMapper;
    }


}
