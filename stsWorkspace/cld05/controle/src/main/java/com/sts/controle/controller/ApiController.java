package com.sts.controle.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
public class ApiController {
    final RestTemplate restTemplate;
    final KafkaTemplate kafkaTemplate;
    final ObjectMapper objectMapper;

    @GetMapping("/api/v1/emp/")
    public ResponseEntity<?> list(){
        return restTemplate.getForEntity("http://localhost:7011/"
                , List.class);
    }

    @PostMapping("/api/v1/emp/")
    public ResponseEntity<?> post(@RequestBody Map<String,Object> map) throws Exception {
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // HttpEntity req=new HttpEntity<>(map,headers);
        // restTemplate.postForEntity("http://localhost:7011/"
        //     , map, String.class);
        String msg = objectMapper.writeValueAsString(map);
        kafkaTemplate.send("emppic",map);
        return ResponseEntity.ok().build();
    }


}
