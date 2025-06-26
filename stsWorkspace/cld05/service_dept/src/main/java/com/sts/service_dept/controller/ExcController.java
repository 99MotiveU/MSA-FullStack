package com.sts.service_dept.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcController {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> exec(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
