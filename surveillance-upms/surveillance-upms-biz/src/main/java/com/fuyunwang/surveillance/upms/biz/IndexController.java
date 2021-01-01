package com.fuyunwang.surveillance.upms.biz;

import com.fuyunwang.surveillance.upms.biz.feign.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IHelloService iHelloService;

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

    @GetMapping("test4")
    public String test4(){
        return iHelloService.hello("王小灏");
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
