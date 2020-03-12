package com.hdsx.dubbo.soul.provider;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Dubbo Registry Nacos Provider Bootstrap
 * @since 2.7.0
 */
@EnableAutoConfiguration
public class ProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderBootstrap.class).run(args);
    }
}
