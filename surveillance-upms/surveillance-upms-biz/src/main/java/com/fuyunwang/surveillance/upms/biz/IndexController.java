package com.fuyunwang.surveillance.upms.biz;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fuyunwang.surveillance.upms.biz.feign.IHelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Api(value = "IndexController",tags = {"门户Controller"})
@RestController
public class IndexController {

    @Autowired
    private IHelloService iHelloService;

    @ApiOperation(value = "test1",notes = "test1 notes",httpMethod = "GET")
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

/*
    @GetMapping("test4")
    @SentinelResource(value = "bizTest1",blockHandler = "doOnBlock")
    public String test4(){
        String name="王小灏";
        try(Entry entry=SphU.entry("bizTest1")){
               name="王澍";
        }catch (BlockException e) {
            log.error("QPS太大");
        }
        return iHelloService.hello(name);
    }
*/

    @GetMapping("test5")
    @SentinelResource(value = "bizTest1",blockHandler = "doOnBlock")
    public String test5() throws InterruptedException {
        String name="Gopher";
        Thread.sleep(50);
        return "ddddd";
//        throw new RuntimeException("发生异常");
    }
    public String doOnBlock(BlockException blockException) throws InterruptedException{
        //降级后的逻辑
        log.error("blocked by "+blockException.getClass().getSimpleName());
        return "doOnBlock Method";
    }
    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
