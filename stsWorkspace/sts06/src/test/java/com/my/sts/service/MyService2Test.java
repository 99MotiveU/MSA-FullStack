package com.my.sts.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class MyService2Test {
	@Autowired
	MyService2 service;

	@Test
	public void test() {
//		assertNotNull(service);
		service.func01();
		service.func02("test");
		System.out.println(service.func03());
		service.func04();
	}

}
