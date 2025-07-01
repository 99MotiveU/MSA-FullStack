package com.sts.servicee.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sts.servicee.domain.EmpVo;
import com.sts.servicee.service.LocalService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class ApiController {
    final LocalService service;

    @GetMapping("/")
    public List<?> list() {
        return service.selectAll();
    }

    // @PostMapping("/")
    // public EmpVo add(@RequestBody EmpVo bean) {
    //     return service.add(bean);
    // }
    
}
