package com.example.apigatewaydynamicrouter;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayDynamicRouterApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiGatewayDynamicRouterApplication.class).web(true).run(args);
	}

	@Bean
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties(){
		return new ZuulProperties();
	}
}
