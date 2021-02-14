package com.fuyunwang.surveillance.upms.api;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
//    @Transactional(rollbackFor = Exception.class)  采用分布式锁+redis预减库存，
    @GetMapping("redisson")
    public String redisson(){
        RLock lock = redissonClient.getLock("lock");
        try {
            boolean b = lock.tryLock();
            if (b){
                log.info("抢到了锁");
                // 执行业务逻辑
                Thread.sleep(3000);
            }else{
                log.info("没抢到锁");
            }
        } catch (Exception e) {
            //如有事务进行回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  手动回滚
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


        return "Test Redisson";
    }
}
