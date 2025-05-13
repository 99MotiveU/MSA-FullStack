package com.my.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
	static Logger logger;
	static DeptDto target;
	DeptDao dao;

	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
		logger=Logger.getLogger(DeptDaoTest.class.getCanonicalName());
		target=new DeptDto(1111,"본사","서울");
	}

	@Before
	public void setUp() throws Exception {
		dao=new DeptDao();
	}

	@Test
	public void test1SelectAll() throws SQLException {
		for(Object obj:dao.selectAll()){
			logger.info(obj.toString());
		}
		assertTrue(dao.selectAll().size()>0);
	}

	@Test
	public void test2SelectOne() throws SQLException {
		Object obj=dao.selectOne(target.getDeptno());
		assertEquals(target, obj);
	}

	@Test
	public void test3InsertOne() throws SQLException {
		target.setDeptno(6666);
		assertSame(1, dao.insertOne(target));
	}

	@Test
	public void test4UpdateOne() throws SQLException {
		target.setDeptno(6666);
		target.setDname(" ѱ ");
		assertSame(1, dao.updateOne(target));
	}
	
	@Test
	public void test5DeleteOne() throws SQLException {
		target.setDeptno(6666);
		assertSame(1, dao.deleteOne(target.getDeptno()));
	}
}








