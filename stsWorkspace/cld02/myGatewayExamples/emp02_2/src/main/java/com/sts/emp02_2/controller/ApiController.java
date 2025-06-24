package com.sts.emp02_2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class ApiController {
    private final DiscoveryClient discoveryClient;
	// private final RestClient restClient;
    private final RestTemplate restTemplate;
    
    @GetMapping("/")
    public List<?> list() {
        return List.of("아이템1","아이템2","아이템3","아이템4");
    }

    @GetMapping("/api/")
    public String getMethodName() {
        ServiceInstance serviceInstance = discoveryClient.getInstances("servicea").get(0);
		
        return restTemplate.getForObject(serviceInstance.getUri(), String.class);
    }
    
    
}
