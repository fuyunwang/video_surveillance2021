package com.fuyunwang.surveillance.upms.api;

import com.fuyunwang.surveillance.common.annotation.ChuoyueCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ChuoyueCloudApplication
public class SurveillanceUpmsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceUpmsApiApplication.class, args);
    }

}
