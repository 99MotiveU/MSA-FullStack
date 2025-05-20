package com.my.sts.service;

import org.springframework.stereotype.Service;

@Service
public class MyService2 {

	public void func01() {
		System.out.println("func01 run...");
	}
	public void func02(String msg) {
		System.out.println("func02 param:"+msg);
	}
	public String func03() {
		System.out.println("func03 return hello");
		return "hello";
	}
	public void func04() {
		System.out.println("func04 begin");
		int su=0/0;
		System.out.println("func04 end");
	}
}
