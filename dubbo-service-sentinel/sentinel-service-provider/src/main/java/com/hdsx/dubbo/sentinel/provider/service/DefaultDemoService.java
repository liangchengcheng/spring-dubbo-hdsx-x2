package com.hdsx.dubbo.sentinel.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.hdsx.dubbo.sentinel.api.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Default {@link DemoService}
 * @see DemoService
 * @since 2.7.0
 */

// @Component
@org.apache.dubbo.config.annotation.Service(version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {

    @Autowired
    public DefaultDemoService(){ }

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;



    @Override
    public String sayHello(String name) {
        // 模拟接口运行时抛出代码异常
        if ("000".equals(name)) {
            throw new RuntimeException();
        }

        return String.format("[%s] : Hello, %s", serviceName, name);
    }

}