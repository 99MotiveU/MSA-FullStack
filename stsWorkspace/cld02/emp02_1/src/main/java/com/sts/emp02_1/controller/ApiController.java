package com.sts.emp02_1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sts.emp02_1.config.MyEvent;
import com.sts.emp02_1.config.MyEvent.MyEvent2;
import com.sts.emp02_1.model.EmpVo;
import com.sts.emp02_1.model.entity.Emp;
import com.sts.emp02_1.service.EmpService;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ApplicationEventPublisher publisher;
    private final EmpService service;
    
    @GetMapping("/")
    public ListIterator<EmpVo> list() {
        MyEvent my=new MyEvent(MyEvent2.builder()
                                        .type(MyEvent.ALL)
                                        .build());
        publisher.publishEvent(my);
        return service.selectAll();
    }

    @PostMapping("/")
    public EmpVo add(@RequestBody EmpVo bean) {
        publisher.publishEvent(new MyEvent(MyEvent2.builder()
                                            .type(MyEvent.ADD)
                                            .params(bean)
                                            .build()));             
        return service.insertOne(bean);
    }
    
    
}
