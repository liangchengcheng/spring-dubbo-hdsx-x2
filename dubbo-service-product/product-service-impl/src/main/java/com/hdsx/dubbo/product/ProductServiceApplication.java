package com.hdsx.dubbo.product;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hdsx.dubbo.product.dao")
@EnableDubboConfig
@DubboComponentScan("com.hdsx.dubbo.product.service")
@SpringBootApplication
public class ProductServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);

        System.out.println( "Hello ProductServiceApplication!" );

        System.out.println("----> ProductServiceApplication start");
        logger.trace("--> ProductServiceApplication start.");
        logger.debug("--> ProductServiceApplication start.");
        logger.info("--> ProductServiceApplication start.");
        logger.warn("--> ProductServiceApplication start.");
        logger.error("--> ProductServiceApplication start.");
        System.out.println("----> ProductServiceApplication start");
    }

}
