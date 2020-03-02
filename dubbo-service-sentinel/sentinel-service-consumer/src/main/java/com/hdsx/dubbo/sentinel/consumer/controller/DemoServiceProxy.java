package com.hdsx.dubbo.sentinel.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.hdsx.dubbo.sentinel.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoServiceProxy {
    private static final String KEY = "sayHello";

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @SentinelResource(
            value = "sayHello",
            blockHandler = "handleFlowQpsException",
            fallback = "sayHelloFallback")
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(@RequestParam("name") String name) {
        try{
            return demoService.sayHello(name);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";

    }


    @SentinelResource(
            value = "sayHello1",
            blockHandlerClass = {ExceptionUtil.class},
            blockHandler = "handleException",
            fallbackClass = {FallbacknUtil.class},
            fallback = "sayHelloFallback")
    @RequestMapping("/sayHello1")
    @ResponseBody
    public String sayHello1(@RequestParam("name") String name) {
        try{
            return demoService.sayHello(name);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";

    }

    /**
     * 查询接口抛出限流或降级时的处理逻辑
     * 注意: 方法参数、返回值要与原函数保持一致
     */
    public String handleFlowQpsException(String name, BlockException e) {
        e.printStackTrace();
        return "限流或降级 sayHello: " + name;
    }

    /**
     * 订单查询接口运行时抛出的异常提供fallback处理
     * 注意: 方法参数、返回值要与原函数保持一致
     */
    public String sayHelloFallback(String name, Throwable e) {
        return "运行时抛出的异常 sayHello: " + name;
    }


    /**
     * 初始化限流配置
     */
    @PostConstruct
    public void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule1 = new FlowRule();
        rule1.setResource(KEY);
        // QPS控制在2以内
        rule1.setCount(2);
        // QPS限流
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setLimitApp("default");
        rules.add(rule1);
        FlowRuleManager.loadRules(rules);
    }

    //    /**
//     * 可以不配置
//     */
//    @PostConstruct
//    public void initDegradeRule() {
//        List<DegradeRule> rules = new ArrayList<>();
//        DegradeRule rule = new DegradeRule();
//        rule.setResource(KEY);
//        // 80s内调用接口出现异常次数超过5的时候, 进行熔断
//        rule.setCount(5);
//        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
//        rule.setTimeWindow(80);
//        rules.add(rule);
//        DegradeRuleManager.loadRules(rules);
//    }
}
