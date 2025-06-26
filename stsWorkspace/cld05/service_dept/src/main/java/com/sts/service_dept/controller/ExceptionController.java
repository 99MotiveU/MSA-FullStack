package com.sts.service_dept.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionController {

    public ResponseEntity<?> exec(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
