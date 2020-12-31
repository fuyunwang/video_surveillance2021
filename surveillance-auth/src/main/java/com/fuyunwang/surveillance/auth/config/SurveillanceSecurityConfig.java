package com.fuyunwang.surveillance.auth.config;

import com.fuyunwang.surveillance.auth.filter.ValidateCodeFilter;
import com.fuyunwang.surveillance.auth.prop.ChuoyueAuthProperties;
import com.fuyunwang.surveillance.auth.security.service.SurveillanceUserDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/30 10:18
 */
@Order(2)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SurveillanceSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SurveillanceUserDetailService userDetailService;
    @Autowired
    private ChuoyueAuthProperties chuoyueAuthProperties;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] anonUrls= StringUtils.splitByWholeSeparatorPreserveAllTokens(chuoyueAuthProperties.getAnonPath(),",");
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .requestMatchers()
//                .antMatchers("/**")
                .antMatchers("/oauth/**")
                .and()
                .authorizeRequests()
//                .antMatchers("/captcha").permitAll()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .csrf().disable()
//                .cors().disable()
                ;
//                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }

    /**
     * @Description 密码模式需要定义以下Bean
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
