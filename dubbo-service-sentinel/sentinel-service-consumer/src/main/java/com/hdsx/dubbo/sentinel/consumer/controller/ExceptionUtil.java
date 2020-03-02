package com.hdsx.dubbo.sentinel.consumer.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExceptionUtil {

    public static String handleException(String name, BlockException e) {
        e.printStackTrace();
        return "限流或降级 sayHello: " + name;
    }
}
