package com.hdsx.dubbo.product;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfig
@DubboComponentScan("com.hdsx.dubbo.product.controller")
@SpringBootApplication
public class ProductRestApplication {

	public static void main(String[] args) {
	    SpringApplication.run(ProductRestApplication.class, args);
	}

}
