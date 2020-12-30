package com.fuyunwang.surveillance.common.configure;

import com.fuyunwang.chuoyue.common.base.GlobalConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/**
 * @Date: 2020/10/4 11:46
 * @Author: FuyunWang
 * @Description: Feign调用服务的过程中token在此定义并添加
 */
public class ChuoyueOAuth2FeignConfigure {
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            // 添加 Zuul Token
            String zuulToken = new String(Base64Utils.encode(GlobalConstant.ZuulFilterConstant.ZUUL_TOKEN_VALUE.getBytes()));
            requestTemplate.header(GlobalConstant.ZuulFilterConstant.ZUUL_TOKEN_HEADER, zuulToken);

            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
            }
        };
    }
}
