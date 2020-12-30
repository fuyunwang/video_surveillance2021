package com.fuyunwang.surveillance.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value={"com.fuyunwang.surveillance.auth.mapper*"})
@SpringBootApplication
public class SurveillanceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceAuthApplication.class, args);
    }

}
