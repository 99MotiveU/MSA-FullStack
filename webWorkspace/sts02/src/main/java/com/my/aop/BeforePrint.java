package com.my.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;

import com.my.module.Module10;

public class BeforePrint implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println(method.getName());
		System.out.println(method.getReturnType());
		System.out.println(Arrays.toString(args));
		System.out.println(target);
	}

}








