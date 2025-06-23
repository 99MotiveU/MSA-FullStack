package com.sts.userapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.userapi.model.UserVo;
import com.sts.userapi.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class ApiController {
    private final UserService service;
    @PostMapping("/")
    public ResponseEntity<?> join(@RequestBody UserVo bean) {
        
        return ResponseEntity.ok(service.add(bean));
    }

    @GetMapping("/")
    public ResponseEntity<?> sign(UserVo bean,HttpSession session) {
        System.out.println(session.getId());
        Optional<UserVo> opt=service.sign(bean);
        if(opt.isPresent()){
            session.setAttribute("login", "true");
            session.setAttribute("loginID", opt.get().getName());
            return ResponseEntity.of(opt);
        }else
            return ResponseEntity.badRequest().build();
    }
    
    @DeleteMapping("/{name}")
    public ResponseEntity<?> delete(@PathVariable String name){
        service.deleteOne(name);
        return ResponseEntity.ok().build();
    }
    
}
