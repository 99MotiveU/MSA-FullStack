package com.sts.deptapi.controller;

import java.net.http.HttpResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.deptapi.model.DeptVo;
import com.sts.deptapi.service.DeptService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/dept")
@RequiredArgsConstructor
public class ApiController {
    private final DeptService service;

    @GetMapping("/")
    public ResponseEntity<?> list(HttpSession session){
        if(session.getAttribute("login")!=null){
            if(session.getAttribute("login").toString().equals("true")){
                return ResponseEntity.ok(
                    service.selectAll()
                );
            }
        }
        return ResponseEntity.status(HttpServletResponse.SC_NOT_ACCEPTABLE).build();
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody DeptVo bean) {
        DeptVo result=service.insertOne(bean);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{deptno}")
    public ResponseEntity<?> get(@PathVariable int deptno) {
        DeptVo bean = service.selectOne(deptno);
        return ResponseEntity.ok(bean);
    }

    @PutMapping("/{deptno}")
    public ResponseEntity<?> set(@PathVariable int deptno
                                ,@RequestBody DeptVo bean) {
        
        return ResponseEntity.ok(
            service.updateOne(bean)
        );
    }

    @DeleteMapping("/{deptno}")
    public ResponseEntity<?> pop(@PathVariable int deptno){
        return ResponseEntity.ok(service.deleteOne(deptno));
    }
}
