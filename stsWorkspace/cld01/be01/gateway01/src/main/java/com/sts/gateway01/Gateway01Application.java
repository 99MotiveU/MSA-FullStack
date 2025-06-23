package com.sts.gateway01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Gateway01Application {

	public static void main(String[] args) {
		SpringApplication.run(Gateway01Application.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
		.route(ele->{
			return ele.order(10).path("/**").uri("http://localhost:3000");
		})
		.route(ele->{
			return ele.order(1).path("/api/dept/**").uri("http://localhost:8091");
		})
		.route(ele->{
			return ele.order(0).path("/api/user/**").uri("http://localhost:8092");
		})
		.build();
	}
}
