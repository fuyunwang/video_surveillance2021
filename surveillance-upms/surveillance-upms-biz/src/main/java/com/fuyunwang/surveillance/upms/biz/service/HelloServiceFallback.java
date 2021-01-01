package com.fuyunwang.surveillance.upms.biz.service;

import com.fuyunwang.surveillance.upms.biz.feign.IHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/1/1 20:56
 */
@Slf4j
public class HelloServiceFallback implements FallbackFactory<IHelloService> {
    @Override
    public IHelloService create(Throwable throwable) {
        return new IHelloService() {
            @Override
            public String hello(String name) {
                log.error("调用surveillance-upms-api服务出错", throwable);
                return "调用出错";
            }
        };
    }
}
