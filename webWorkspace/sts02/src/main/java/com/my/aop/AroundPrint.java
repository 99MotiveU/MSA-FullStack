package com.my.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundPrint implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("before");
		Object obj=null;
		try {
			obj=invocation.proceed();
			System.out.println("after returnning...");
		}catch (Exception e) {
			System.out.println("after err...");
		}
		System.out.println("after all...");
		return obj;
	}

}
