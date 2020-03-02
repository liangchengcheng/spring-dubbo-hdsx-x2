package com.hdsx.dubbo.user;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.hdsx.dubbo.user.dao")
@EnableDubboConfig
@DubboComponentScan("com.hdsx.dubbo.user.service")
@SpringBootApplication
public class UserServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);

        System.out.println( "Hello World!" );

        System.out.println("----> UserServiceApplication start");
        logger.trace("--> UserServiceApplication start.");
        logger.debug("--> UserServiceApplication start.");
        logger.info("--> UserServiceApplication start.");
        logger.warn("--> UserServiceApplication start.");
        logger.error("--> UserServiceApplication start.");
        System.out.println("----> UserServiceApplication start");
    }

}
