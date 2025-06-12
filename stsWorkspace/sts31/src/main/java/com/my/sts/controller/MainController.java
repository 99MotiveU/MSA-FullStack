package com.my.sts.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
	private final StringRedisTemplate template;
	
	@GetMapping("/chat")
	public String send(String msg) {
		template.convertAndSend("chat", msg);
		return msg;
	}
}
