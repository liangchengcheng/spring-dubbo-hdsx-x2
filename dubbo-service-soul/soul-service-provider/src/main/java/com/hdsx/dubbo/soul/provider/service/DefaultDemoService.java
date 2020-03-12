package com.hdsx.dubbo.soul.provider.service;

import com.hdsx.dubbo.soul.api.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.dromara.soul.client.common.annotation.SoulClient;
import org.springframework.beans.factory.annotation.Value;

/**
 * Default {@link DemoService}
 * @see DemoService
 * @since 2.7.0
 */
@Service(version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @SoulClient(path = "/sayHello", desc = "说你好")
    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}