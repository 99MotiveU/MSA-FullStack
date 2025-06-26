package com.sts.service_dept.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.service_dept.domain.DeptVo;
import com.sts.service_dept.service.DeptService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/dept")
@RequiredArgsConstructor
public class ApiController {
    final DeptService deptService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(deptService.selectAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody DeptVo bean) {
        return ResponseEntity.ok().body(deptService.insertOne(bean));
    }
    
    
}
