package com.sts.dept02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RefreshScope
@RestController
public class ApiController {
    
  @Value("${foo:Hello default}")
  private String message;

  @GetMapping("/message")
  String getMessage() {
    return this.message;
  }
    
}
