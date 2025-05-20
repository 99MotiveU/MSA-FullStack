package com.my.sts.service;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.my.sts.model.DeptVo;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptServiceTest {

	@Autowired
	DeptService deptService;
	Model model;
	DeptVo target;
	
	@Before
	public void initModel() {
		model=new BindingAwareModelMap();
	}
	@Before
	public void initTarget() {
		target=new DeptVo(1111,"test","test");
	}
	@After
	public void printModel() {
		Map<String, Object> map = model.asMap();
		Set<Entry<String, Object>> entrys = map.entrySet();
		for(Entry<String, Object> entry:entrys) {
			System.out.println(entry);
		}
	}
	
	@Test
	public void testList() {
		deptService.selectAll(model);
	}
	
	@Test
	public void testDept() {
		deptService.select(model, target.getDeptno());
	}
	
	@Test
	public void testAdd() {
		target.setDeptno(1007);
		deptService.addOne(target);
	}
	
	@Test
	public void testEdit() {
		target.setDname("Å×½ºÆ®");
		assertTrue(deptService.editOne(target));
	}
	@Test
	public void testDelete() {
		assertTrue(deptService.delOne(target.getDeptno()));
	}

}







