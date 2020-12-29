package com.fuyunwang.surveillance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/29 18:46
 */
@EnableConfigServer
@SpringBootApplication
public class SurveillanceConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SurveillanceConfigApplication.class,args);
    }
}
