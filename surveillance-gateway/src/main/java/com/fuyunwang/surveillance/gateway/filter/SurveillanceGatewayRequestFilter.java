package com.fuyunwang.surveillance.gateway.filter;

import com.fuyunwang.surveillance.common.base.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/31 10:50
 */
@Slf4j
@Component
public class SurveillanceGatewayRequestFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        byte[] token = Base64Utils.encode((GlobalConstant.GatewayFilterConstant.GATEWAY_TOKEN_VALUE).getBytes());
        ServerHttpRequest build = request.mutate().header(GlobalConstant.GatewayFilterConstant.GATEWAY_TOKEN_HEADER, new String(token)).build();
        ServerWebExchange newExchange = exchange.mutate().request(build).build();
        return chain.filter(newExchange);
    }
}
