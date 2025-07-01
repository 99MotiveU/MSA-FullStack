package com.sts.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final TokenService tokenService;
    
    @GetMapping("/")
    public String login() {
        return tokenService.jwtCreate("user01");
    }
    
}
