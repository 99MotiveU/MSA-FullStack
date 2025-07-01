package com.sts.control_dept.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sts.control_dept.model.DeptVo;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/dept")
@RequiredArgsConstructor
public class ApiController {
    
    final DiscoveryClient discoveryClient;
    final RestTemplate restTemplate;
    ServiceInstance instance;

    @GetMapping("/")
    public List<?> list() {
        instance=discoveryClient.getInstances("SERVICED").get(0);
        String url=
        instance.getUri().toASCIIString()+"/api/v1/dept/";
        System.out.println(url);
        return restTemplate.getForObject(url, List.class);
    }

    @PostMapping("/")
    public String add(@RequestBody DeptVo bean) {
        instance=discoveryClient.getInstances("SERVICED").get(0);
        String url=instance.getUri().toString()+"/api/v1/dept/";

        // MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        // params.add("deptno", bean.getDeptno());
        // params.add("dname", bean.getDname());
        // params.add("loc", bean.getLoc());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // headers.set("Content-Type", "application/json");
        HttpEntity<?> req = new HttpEntity<>(bean, headers);
        
        return restTemplate.postForObject(url, req, String.class);
    }
    
    
}









