package com.my.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeController implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if(method.getName().equals("handleRequest")) {
			HttpServletRequest req=(HttpServletRequest) args[0];
			if("POST".equals(req.getMethod())) {
				req.setCharacterEncoding("utf-8");
			}
		}
	}

}











