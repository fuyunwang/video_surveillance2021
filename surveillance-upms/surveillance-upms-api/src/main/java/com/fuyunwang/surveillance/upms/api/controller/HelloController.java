package com.fuyunwang.surveillance.upms.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/1/1 20:52
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) throws InterruptedException {
        Thread.sleep(500);
        return "hello this is from api service: " + name;
    }}
