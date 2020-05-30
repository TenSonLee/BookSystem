package com.jl.graduatedesign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.jl.graduatedesign.dao"})
public class StartApplication {
    public static void main(String[] args){
        SpringApplication.run(StartApplication.class);
    }
}
