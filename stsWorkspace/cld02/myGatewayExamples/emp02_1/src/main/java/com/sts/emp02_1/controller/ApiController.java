package com.sts.emp02_1.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ApiController {
    
    @GetMapping("/")
    public List<?> list() {
        return List.of("item1","item2","item3","item4");
    }
    
}
