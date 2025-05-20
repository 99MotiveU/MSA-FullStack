package com.my.sts.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptDaoTest {
	@Autowired
	DeptDao deptDao;
	DeptVo target=new DeptVo(1111,"test","test");

	@Test
	public void test() {
		assertNotNull(deptDao);
	}
	
	@Test
	public void testSelectAll() {
		assertNotNull(deptDao.selectAll());
		assertFalse(deptDao.selectAll().size()==0);
	}
	
	@Test
	public void testSelect() {
		assertEquals(target, deptDao.select(target.getDeptno()));
	}
	
	@Test
	@Transactional
	public void testInsertOne() {
		DeptVo target=new DeptVo(1007,"test","test");
		deptDao.insertOne(target);
	}
	
	@Test
	@Transactional
	public void testUpdateOne() {
		target.setDname("Å×½ºÆ®");
		assertSame(1, deptDao.updateOne(target));
	}
	
	@Test
	@Transactional
	public void testDeleteOne() {
		assertSame(1, deptDao.deleteOne(target.getDeptno()));
	}

}










