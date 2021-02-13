package com.fuyunwang.surveillance.upms.api.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/2/13 18:46
 */
@Slf4j
@Configuration
public class XxlJobConfigure {

    @XxlJob("apiXxlJobHandler")
    public ReturnT<String> execute(String param) {
        log.info("ApiXxlJobHandler");
        XxlJobHelper.log("ApiXxlJobHandler");
        return ReturnT.SUCCESS;
    }

}
