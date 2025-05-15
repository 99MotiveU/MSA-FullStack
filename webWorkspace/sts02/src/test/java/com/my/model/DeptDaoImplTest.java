package com.my.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.cj.jdbc.MysqlDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoImplTest {
	static ApplicationContext ac;
	DeptDao dao;
	DeptDto target;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
		dao=ac.getBean(DeptDaoImpl.class);
		target=new DeptDto(1010,"test","test");
	}

	@Test
	public void test1SelectAll() {
		assertNotNull(dao.selectAll());
	}
	
	@Test
	public void test2InsertOne() {
		dao.insertOne(target);
	}
	
	@Test
	public void test3SelectOne() {
		assertEquals(target, dao.selectOne(target.getDeptno()));
	}
	
	@Test
	public void test4UpdateOne() {
		target.setDname("test2");
		assertSame(1, dao.updateOne(target));
	}

	@Test
	public void test5DeleteOne() {
		assertSame(1, dao.deleteOne(target.getDeptno()));
	}
}












