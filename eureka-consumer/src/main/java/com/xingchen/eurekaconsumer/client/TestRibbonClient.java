package com.xingchen.eurekaconsumer.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestRibbonClient {
    @Value("${server.port}")
    private String port;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test")
    @HystrixCommand(fallbackMethod = "hiFallback")
    public String test() {

        long start = System.currentTimeMillis();
        String result = this.restTemplate.getForObject("http://service-client/hi", String.class);
        long end = System.currentTimeMillis();
        return result;
    }

    public String hiFallback() {
        return "hi异常，端口：" + port;
    }
}
