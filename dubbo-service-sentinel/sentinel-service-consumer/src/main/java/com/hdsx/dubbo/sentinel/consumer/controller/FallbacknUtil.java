package com.hdsx.dubbo.sentinel.consumer.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class FallbacknUtil {

    public static String sayHelloFallback(String name, Throwable e) {
        return "运行时抛出的异常 sayHello: " + name;
    }
}
