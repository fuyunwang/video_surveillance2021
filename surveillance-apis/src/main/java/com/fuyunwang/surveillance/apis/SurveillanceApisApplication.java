package com.fuyunwang.surveillance.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class SurveillanceApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceApisApplication.class, args);
    }

}
