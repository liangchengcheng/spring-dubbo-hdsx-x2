package com.hdsx.dubbo.sentinel.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Dubbo Registry Nacos Provider Bootstrap
 * @since 2.7.0
 */
//@ComponentScan(basePackages = "com.hdsx.dubbo")
@SpringBootApplication
// @EnableAutoConfiguration
public class ProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderBootstrap.class).run(args);
    }
}
