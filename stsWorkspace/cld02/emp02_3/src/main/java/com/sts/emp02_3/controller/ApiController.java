package com.sts.emp02_3.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/")
    public List<?> list() {
        return List.of("a아이템1","a아이템2","a아이템3","a아이템4");
    }
   
}
