package com.fuyunwang.surveillance.common.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/2/9 14:30
 */
@Configuration
public class ChuoyueWebMvcConfigure {
    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }
}
