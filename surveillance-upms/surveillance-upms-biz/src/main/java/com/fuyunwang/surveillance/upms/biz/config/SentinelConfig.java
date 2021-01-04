package com.fuyunwang.surveillance.upms.biz.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.google.common.collect.Lists;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: SentinelConfig
 * @Author: FuyunWang
 * @Date: 2021/1/4 20:34
 */
@Component
public class SentinelConfig implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        FlowRule flowRule=new FlowRule();
        flowRule.setResource("bizTest1");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(10);
        List<FlowRule> list= Lists.newArrayList();
        list.add(flowRule);
        FlowRuleManager.loadRules(list);

        // 1s中有5个请求都超时，则熔断。判断是否超时即看是否超过10 ms. 10s进行一次时间窗口请求
        DegradeRule degradeRule=new DegradeRule();
        degradeRule.setResource("bizTest1");
//        degradeRule.setMinRequestAmount(RuleConstant.DEGRADE_DEFAULT_MIN_REQUEST_AMOUNT);
//        degradeRule.setSlowRatioThreshold(RuleConstant.DEGRADE_DEFAULT_SLOW_REQUEST_AMOUNT);
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        degradeRule.setCount(10);
        degradeRule.setTimeWindow(10);
//        degradeRule.setLimitApp("default");
        List<DegradeRule> degradeRules=Lists.newArrayList();
        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules(degradeRules);
    }
}
