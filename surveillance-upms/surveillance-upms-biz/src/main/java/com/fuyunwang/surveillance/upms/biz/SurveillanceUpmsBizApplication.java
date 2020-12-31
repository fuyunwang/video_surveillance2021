package com.fuyunwang.surveillance.upms.biz;

import com.fuyunwang.surveillance.common.annotation.ChuoyueCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ChuoyueCloudApplication
public class SurveillanceUpmsBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceUpmsBizApplication.class, args);
    }

}
