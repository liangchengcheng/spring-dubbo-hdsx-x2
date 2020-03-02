package com.hdsx.dubbo.order.application;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfig
@DubboComponentScan("com.hdsx.dubbo.order.application.controller")
@SpringBootApplication
public class OrderRestfulApplication {

	public static void main(String[] args) {
	    SpringApplication.run(OrderRestfulApplication.class, args);
	}

}