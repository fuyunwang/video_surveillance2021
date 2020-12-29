package com.fuyunwang.surveillance.surveillance.apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/29 19:31
 */
@RestController
public class IndexController {

    @Value("${foo}")
    String foo;

    @GetMapping("/foo")
    public String foo(){
        return foo;
    }
}
