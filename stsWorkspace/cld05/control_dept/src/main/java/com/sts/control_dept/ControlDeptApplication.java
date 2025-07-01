package com.sts.control_dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ControlDeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlDeptApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
