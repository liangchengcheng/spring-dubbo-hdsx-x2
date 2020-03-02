package com.hdsx.dubbo.order;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hdsx.dubbo.order.dao")
@EnableDubboConfig
@DubboComponentScan({"com.hdsx.dubbo.order.service"})
@SpringBootApplication
public class OrderServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);

        System.out.println( "Hello OrderServiceApplication!" );

        System.out.println("----> OrderServiceApplication start");
        logger.trace("--> OrderServiceApplication start.");
        logger.debug("--> OrderServiceApplication start.");
        logger.info("--> OrderServiceApplication start.");
        logger.warn("--> OrderServiceApplication start.");
        logger.error("--> OrderServiceApplication start.");
        System.out.println("----> OrderServiceApplication start");
    }

}
