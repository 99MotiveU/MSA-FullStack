package com.my.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service02Test {
	static ApplicationContext ac;
	Service02 service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("/applicationContext3.xml");
	}

	@Before
	public void setUp() throws Exception {
		service=ac.getBean(Service02.class);
	}

	@Test
	public void testExec() {
		service.exec();
	}

}
