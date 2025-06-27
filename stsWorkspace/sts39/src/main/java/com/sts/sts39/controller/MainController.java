package com.sts.sts39.controller;

import org.springframework.web.bind.annotation.RestController;
import com.sts.sts39.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequiredArgsConstructor
public class MainController {
    final JwtService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/ex01")
    public String ex01(String token) {
        return service.Verify(token);
    }
    @GetMapping("/ex02")
    public String ex2() {
        return new String();
    }

    @GetMapping("/login")
    public String login(String id) {
        return service.create(id);
    }

}
