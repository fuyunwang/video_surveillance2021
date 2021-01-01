package com.fuyunwang.surveillance.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SurveillanceMonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceMonitorAdminApplication.class, args);
    }

}
