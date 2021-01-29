package com.fuyunwang.surveillance.apis.controller;

import com.fuyunwang.surveillance.apis.entity.Cat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Description: 配置使用Date
 * @Author: FuyunWang
 * @Date: 2021/1/29 21:00
 */
@RestController
public class DateTimeTestController {

    @RequestMapping("/gettime")
    public Object getTime(@RequestParam("time") LocalTime cat){
        System.out.println(cat);
        return cat;
    }
}
