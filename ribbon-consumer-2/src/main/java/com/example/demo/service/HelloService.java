package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKey2")
    public String helloService(){
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend Time:"+(end-start));
        return result.toString();
    }

    public String helloFallback(){
        return "error";
    }
}
