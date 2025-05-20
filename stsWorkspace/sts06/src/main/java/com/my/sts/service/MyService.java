package com.my.sts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sts.di.MyModule;

@Service
public class MyService {
	@Autowired
	MyModule module;
	
	public void service() {
		module.func01();
	}
}
