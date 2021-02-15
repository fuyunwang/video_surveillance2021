package com.fuyunwang.surveillance.upms.api;

import com.fuyunwang.surveillance.common.annotation.ChuoyueCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value={"com.fuyunwang.surveillance.upms.api.mapper*"})
@SpringBootApplication
@EnableTransactionManagement
@ChuoyueCloudApplication
public class SurveillanceUpmsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceUpmsApiApplication.class, args);
    }

}
