package com.example.feignconsumer.fallback;

import com.example.feignconsumer.entity.User;

import com.example.feignconsumer.feign.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
