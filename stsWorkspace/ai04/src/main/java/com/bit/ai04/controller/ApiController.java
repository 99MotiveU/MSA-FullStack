package com.bit.ai04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.ai04.ChatService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    final ChatService chatService;
    
    @GetMapping("/")
    public Flux<String> q(String msg){
        return chatService.func01("guest",msg);
    }
}
