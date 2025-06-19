package com.sts.sts34.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.sts34.model.DeptVo;
import com.sts.sts34.service.ApiService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final ApiService service;

    @GetMapping("/")
    public List<?> list() {
        return service.selectAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> add(DeptVo bean) {
        try{
            DeptVo result = service.insertOne(bean);
            return ResponseEntity.ok(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
    
}
