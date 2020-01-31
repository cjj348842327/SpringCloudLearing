package com.example.apigateway;

import com.example.apigateway.attributes.DidiErrorAttributes;
import com.example.apigateway.filter.AccessFilter;
import com.example.apigateway.processor.DidiFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		FilterProcessor.setProcessor(new DidiFilterProcessor());
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}

	@Bean
	public DefaultErrorAttributes errorAttributes(){
		return new DidiErrorAttributes();
	}
}
