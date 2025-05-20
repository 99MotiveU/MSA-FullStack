package com.my.sts.di;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.sts.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class MyServiceTest {
//	static ApplicationContext ac;
	@Autowired
	MyService myService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		ac=new AnnotationConfigApplicationContext("classpath:/applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
//		myService=ac.getBean(MyService.class);
	}

	@Test
	public void testService() {
		myService.service();
	}

}
