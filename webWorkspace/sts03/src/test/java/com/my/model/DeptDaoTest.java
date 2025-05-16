package com.my.model;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptDaoTest {
	static ApplicationContext ac;
	DeptDao deptDao;
	Logger log=Logger.getLogger(this.getClass());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
		deptDao=ac.getBean(DeptDao.class);
	}

	@Test
	public void test() {
		assertNotNull(deptDao.selectAll());
		log.debug(deptDao.selectAll());
	}

}
