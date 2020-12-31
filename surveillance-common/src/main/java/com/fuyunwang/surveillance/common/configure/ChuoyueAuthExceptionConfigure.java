package com.fuyunwang.surveillance.common.configure;

//import com.fuyunwang.chuoyue.common.handler.ChuoyueAccessDeniedHandler;
//import com.fuyunwang.chuoyue.common.handler.ChuoyueAuthExceptionEntryPoint;
import com.fuyunwang.surveillance.common.handler.ChuoyueAccessDeniedHandler;
import com.fuyunwang.surveillance.common.handler.ChuoyueAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020/10/4 10:33
 * @Author: FuyunWang
 * @Description:
 */
public class ChuoyueAuthExceptionConfigure {

    @Bean
    @Primary
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public ChuoyueAccessDeniedHandler accessDeniedHandler() {
        return new ChuoyueAccessDeniedHandler();
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public ChuoyueAuthExceptionEntryPoint authenticationEntryPoint() {
        return new ChuoyueAuthExceptionEntryPoint();
    }

}
