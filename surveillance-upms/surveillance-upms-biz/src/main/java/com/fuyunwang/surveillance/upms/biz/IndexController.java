package com.fuyunwang.surveillance.upms.biz;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @GetMapping("test1")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String test1(){
        return "拥有'user:add'权限";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String test2(){
        return "拥有'user:update'权限";
    }

    @GetMapping("test3")
    @PreAuthorize("hasAnyAuthority('user:query')")
    public String test3(){
        return "拥有'user:query'权限";
    }
    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
