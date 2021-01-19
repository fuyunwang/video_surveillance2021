package com.fuyunwang.surveillance.apis.controller;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/1/18 20:28
 */
@RestController
public class IdController {

    @Autowired(required = false)
    private SegmentService segmentService;

    @Autowired(required = false)
    private SnowflakeService snowflakeService;

    @GetMapping("/segment")
    public Result segment() {
        return segmentService.getId("leaf-segment-test");
    }
}
