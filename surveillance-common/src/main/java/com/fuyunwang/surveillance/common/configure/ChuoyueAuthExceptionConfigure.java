package com.fuyunwang.surveillance.common.configure;

import com.fuyunwang.chuoyue.common.handler.ChuoyueAccessDeniedHandler;
import com.fuyunwang.chuoyue.common.handler.ChuoyueAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @Date: 2020/10/4 10:33
 * @Author: FuyunWang
 * @Description:
 */
public class ChuoyueAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public ChuoyueAccessDeniedHandler accessDeniedHandler() {
        return new ChuoyueAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public ChuoyueAuthExceptionEntryPoint authenticationEntryPoint() {
        return new ChuoyueAuthExceptionEntryPoint();
    }

}
