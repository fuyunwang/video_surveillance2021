package com.fuyunwang.surveillance.common.configure;

//import com.fuyunwang.chuoyue.common.interceptor.ChuoyueServiceProtectInterceptor;
import com.fuyunwang.surveillance.common.converter.String2DateConverter;
import com.fuyunwang.surveillance.common.interceptor.ChuoyueServiceProtectInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Date: 2020/10/4 12:13
 * @Author: FuyunWang
 * @Description:
 */
public class ChuoyueServiceProtectConfigure implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor chuoyueServiceProtectInterceptor() {
        return new ChuoyueServiceProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(chuoyueServiceProtectInterceptor());
    }
    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new String2DateConverter());
    }*/
}
