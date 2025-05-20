package com.my.sts.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAop {
	
//	@Before("execution(* com.my.sts.service.*.func*(..))")
	public void beforeMethod(JoinPoint join) {
		System.out.println("진짜 수행전...");
		// this
		Object obj=join.getThis();
		// args
		Object[] args=join.getArgs();
		// method name
		String name=join.getSignature().getName();
		System.out.println(name);
	}
	
//	@AfterReturning(returning = "val",pointcut = "execution(* com.my.sts.service.*.func*(..))")
	public void afterReturn(JoinPoint join,Object val) {
		System.out.println("진짜 수행 후...성공:"+val);
	}
	
//	@AfterThrowing(throwing = "ex",pointcut = "execution(* com.my.sts.service.*.func*(..))")
	public void afterErr(JoinPoint join,Exception ex) {
		System.out.println("진짜 수행 후...실패:"+ex.getLocalizedMessage());
	}
	
//	@After("execution(* com.my.sts.service.*.func*(..))")
	public void afterMethod() {
		System.out.println("진짜 수행 후");
	}
	
	@Around("execution(* com.my.sts.service.*.func*(..))")
	public Object around(ProceedingJoinPoint join) {
		System.out.println("before...");
		Object obj=null;
		try {
			obj=join.proceed();
			System.out.println("after...success");
		} catch (Throwable e) {
			System.out.println("after...error");
		}
		System.out.println("after...");
		return obj;
	}
}







