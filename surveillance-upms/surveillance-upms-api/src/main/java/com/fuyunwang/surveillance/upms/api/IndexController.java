package com.fuyunwang.surveillance.upms.api;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/30 21:26
 */
@Slf4j
@RestController
public class IndexController {

    @Autowired
    RedissonClient redissonClient;

    @GetMapping("info")
    public String getInfo() throws InterruptedException {
        Thread.sleep(500);
        return "surveillance-upms-api";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("redisson")
    public String redisson(){
        RLock lock = redissonClient.getLock("lock");
        try {
            boolean b = lock.tryLock();
            if (b){
                log.info("抢到了锁");
                Thread.sleep(3000);
                lock.unlock();
            }else{
                log.info("没抢到锁");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
        }


        return "Test Redisson";
    }
}
