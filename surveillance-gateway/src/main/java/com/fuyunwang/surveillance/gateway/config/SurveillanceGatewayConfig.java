package com.fuyunwang.surveillance.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;

/**
 * @Description: gateway添加统一前缀
 * @Author: FuyunWang
 * @Date: 2020/12/31 19:12
 */
@Configuration
public class SurveillanceGatewayConfig {

    private static final String prefix = "/surveillance";

    @Bean
    @Order(-1)
    public WebFilter apiPrefixFilter(){
        return (serverWebExchange, webFilterChain) -> {
            ServerHttpRequest request=serverWebExchange.getRequest();
            addOriginalRequestUrl(serverWebExchange,request.getURI());
            String path=request.getURI().getRawPath();
            if(!path.contains(prefix)){
                ServerHttpResponse response=serverWebExchange.getResponse();
                response.setStatusCode(HttpStatus.BAD_GATEWAY);
                DataBuffer buffer = response.bufferFactory().wrap(HttpStatus.BAD_GATEWAY.getReasonPhrase().getBytes());
                return response.writeWith(Mono.just(buffer));
            }
            String newPath=path.replaceFirst(prefix,"");
            ServerHttpRequest newRequest=request.mutate().path(newPath).build();
            serverWebExchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR,newRequest.getURI());
            return webFilterChain.filter(serverWebExchange.mutate().request(newRequest).build());
        };
    }

}
