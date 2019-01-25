package com.xingchen.springcloudfegin.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service-client",fallback = ClientFallback.class)
public interface TestFeignClient {
    @GetMapping("/hi")
    String test();
}