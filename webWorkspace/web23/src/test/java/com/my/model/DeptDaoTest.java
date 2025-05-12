package com.my.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
	// 3.x 네임규칙 - test메서드명
	// 4.x 자율 - annotation 이용
	DeptDao dao;
	DeptDto target=new DeptDto(9999,"테스트","강남");
	
	@Before
	public void setUp() {
		dao=new DeptDao();
	}
	@After
	public void tearDown() {
	}
	@Test
	public void test1SelectAll() throws SQLException {
		assertNotNull(dao.selectAll());
		assertNotSame(0, dao.selectAll().size());
//		assertTrue(dao.selectAll().size()>0);
	}
	
	@Test
	public void test3SelectOne() throws SQLException {
		DeptDto bean = dao.selectOne(target.getDeptno());
		assertNotNull(bean);
		assertEquals(target,bean);
	}
	
	@Test
	public void test2InsertOne() throws SQLException {
		assertNotSame(0, dao.insertOne(target));
	}
	
	@Test
	public void test5DeleteOne() throws SQLException {
		assertNotSame(0,dao.deleteOne(target.getDeptno()));
	}
	
	@Test
	public void test4UpdateOne() throws SQLException {
		assertNotSame(0, dao.updateOne(target));
	}

}








