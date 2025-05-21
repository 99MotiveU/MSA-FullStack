package com.my.sts.dept.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.my.sts.dept.model.DeptDao;
import com.my.sts.dept.model.DeptVo;

@Service
public class DeptService {
	@Autowired
	DeptDao deptDao;
	
	public void getList(Model model) {
		model.addAttribute("list", deptDao.selectAll());
	}
	
	public void addList(DeptVo bean) {
		deptDao.insertOne(bean);
	}
	
	public void getList(Model model, int deptno) {
		model.addAttribute("bean",deptDao.selectOne(deptno));
	}
	
	public void editList(DeptVo bean) {
		deptDao.updateOne(bean);
	}

	public boolean rmList(int deptno) {
		return deptDao.deleteOne(deptno)>0?true:false;
	}
}












