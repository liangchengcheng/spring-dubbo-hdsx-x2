package com.hdsx.dubbo.user;

import com.hdsx.dubbo.user.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDubboConfig
@DubboComponentScan("com.hdsx.dubbo.user.controller")
@SpringBootApplication
public class UserRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRestApplication.class, args);
    }
//
//    @Reference(version = "${dubbo.provider.UserService.version}",
//            application = "${spring.application.name}",
//            url = "dubbo://localhost:2181")
//    private UserService userService;
//
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Bean
//    public ApplicationRunner runner() {
//        return args -> logger.info(userService.getUserByName("zhangsan").toString());
//    }
//}
}
