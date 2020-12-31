package com.fuyunwang.surveillance.auth;

import com.fuyunwang.surveillance.common.annotation.ChuoyueCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value={"com.fuyunwang.surveillance.auth.mapper*"})
@SpringBootApplication
@ChuoyueCloudApplication
public class SurveillanceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceAuthApplication.class, args);
    }

}
