package com.fuyunwang.surveillance.upms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/30 21:26
 */
@RestController
public class IndexController {

    @GetMapping("info")
    public String getInfo() throws InterruptedException {
        Thread.sleep(500);
        return "surveillance-upms-api";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
