package com.my.sts05.dept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sts05.dept.model.DeptDao;
import com.my.sts05.dept.model.DeptVo;

@Service
public class DeptService {
	@Autowired
	DeptDao deptDao;
	public List<DeptVo> listPage(){
		deptDao.totSize();
		return deptDao.selectAll();
	}
	
	public void addPage(DeptVo bean) {
		deptDao.insertOne(bean);
	}

	public DeptVo onePage(int deptno) {
		return deptDao.selectOne(deptno);
	}

	public void editPage(DeptVo bean) {
		deptDao.updateOne(bean);
	}

	public void deletePage(int deptno) {
		deptDao.deleteOne(deptno);
	}
}










