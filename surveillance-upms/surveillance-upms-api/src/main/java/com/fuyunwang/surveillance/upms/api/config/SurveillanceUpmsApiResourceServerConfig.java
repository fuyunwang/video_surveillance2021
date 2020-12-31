package com.fuyunwang.surveillance.upms.api.config;

import com.fuyunwang.surveillance.common.handler.ChuoyueAccessDeniedHandler;
import com.fuyunwang.surveillance.common.handler.ChuoyueAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/30 21:05
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SurveillanceUpmsApiResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private ChuoyueAuthExceptionEntryPoint authenticationEntryPoint;
    @Autowired
    private ChuoyueAccessDeniedHandler accessDeniedHandler;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/**").authenticated();
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authenticationEntryPoint);
    }
}
