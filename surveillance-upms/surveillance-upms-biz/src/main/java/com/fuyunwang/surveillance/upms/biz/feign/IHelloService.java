package com.fuyunwang.surveillance.upms.biz.feign;

import com.fuyunwang.surveillance.upms.biz.service.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "surveillance-upms-api", contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
