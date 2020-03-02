package com.hdsx.dubbo.sentinel.consumer.controller;

import com.hdsx.dubbo.sentinel.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo2")
public class Demo2Controller {

    private static final String KEY = "sayHello";

    @Autowired
    private DemoServiceProxy demoServiceProxy;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String demoService(@RequestParam("name") String name) {
        return demoServiceProxy.sayHello(name);
    }

}
