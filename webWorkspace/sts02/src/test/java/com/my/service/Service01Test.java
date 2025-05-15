package com.my.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service01Test {
	static ApplicationContext ac;
	Service01 service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("/applicationContext2.xml");
	}

	@Before
	public void setUp() throws Exception {
		service=(Service01) ac.getBean("service");
	}

	@Test
	public void testServ01() {
		service.serv01();
	}

}








