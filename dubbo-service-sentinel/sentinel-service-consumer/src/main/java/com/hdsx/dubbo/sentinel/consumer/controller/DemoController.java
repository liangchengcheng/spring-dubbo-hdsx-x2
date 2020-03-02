package com.hdsx.dubbo.sentinel.consumer.controller;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.hdsx.dubbo.sentinel.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("demo")
public class DemoController {

    private static final String KEY = "sayHello";

    // @Autowired
    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String demoService(@RequestParam("name") String name) {
        return demoService.sayHello(name);
    }

}
