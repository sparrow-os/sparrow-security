package com.sparrow.security.admin.controller;

import com.sparrow.spring.starter.config.SparrowConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private SparrowConfig sparrowConfig;

    @RequestMapping("/hello")
    public String hello() {
        return this.sparrowConfig.getProfile();
    }

    @RequestMapping("/integer")
    public Integer integer() {
        return 1;
    }
}
