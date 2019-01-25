package com.xingchen.springcloudfegin.controller;

import org.springframework.stereotype.Component;

@Component
public class ClientFallback implements TestFeignClient {

    public String test() {
        return "服务调用失败";
    }
}
