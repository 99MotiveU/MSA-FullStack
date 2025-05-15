package com.my.aop;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.ThrowsAdvice;

public class ErrPrint implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("==============================");
	}
}
