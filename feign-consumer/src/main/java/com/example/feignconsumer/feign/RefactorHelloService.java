package com.example.feignconsumer.feign;

import com.example.helloserviceapi.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "hello-service")
public interface RefactorHelloService extends HelloService {
}
