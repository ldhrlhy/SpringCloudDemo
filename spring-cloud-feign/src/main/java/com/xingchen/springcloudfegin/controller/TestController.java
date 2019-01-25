package com.xingchen.springcloudfegin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestFeignClient testFeignClient;

    @GetMapping("/test")
    public String ListUsers(){
        String users = this.testFeignClient.test();
        return users;
    }
}
