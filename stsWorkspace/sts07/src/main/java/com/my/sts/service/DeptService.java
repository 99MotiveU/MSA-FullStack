package com.my.sts.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.my.sts.model.DeptDao;
import com.my.sts.model.DeptVo;

@Service
public class DeptService {
	//@Autowired
	DeptDao deptDao;
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Transactional(readOnly = true)
	public void selectAll(Model model) {
		try(
	SqlSession sqlSession=sqlSessionFactory.openSession();
				){
			deptDao=sqlSession.getMapper(DeptDao.class);
			model.addAttribute("list",deptDao.selectAll());
		}
	}
	
	@Transactional(readOnly = true)
	public void select(Model model,int deptno) {
//		model.addAttribute("bean", deptDao.select(deptno));
	}
	
	@Transactional
	public void addOne(DeptVo bean) {
		try(
	SqlSession sqlSession=sqlSessionFactory.openSession();		
				){
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		deptDao.insertOne(bean);
		}
	}
	
	@Transactional
	public boolean editOne(DeptVo bean) {
//		return deptDao.updateOne(bean)>0;
		return true;
	}
	
	@Transactional
	public boolean delOne(int deptno) {
//		return deptDao.deleteOne(deptno)>0;
		return true;
	}
}










