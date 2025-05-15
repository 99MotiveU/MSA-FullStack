package com.my.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.my.model.DeptDto;

public class AfterDao implements AfterReturningAdvice {
	Logger log=Logger.getLogger(getClass());

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		List<DeptDto> list=(List<DeptDto>) returnValue;
		for(DeptDto bean:list) {
			log.debug(bean);
		}

	}

}
