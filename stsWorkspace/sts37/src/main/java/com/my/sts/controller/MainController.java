package com.my.sts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.my.sts.DeptService;
import com.my.sts.model.DeptVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
	final DeptService service;

	@PostMapping("/")
	public DeptVo add(DeptVo bean) throws JsonProcessingException {
		for(int i=1; i<20; i++) {
			service.insertOne(bean);
			bean.setDeptno(bean.getDeptno()+i);
		}
		return bean;
	}
}
