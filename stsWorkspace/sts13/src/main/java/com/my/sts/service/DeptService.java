package com.my.sts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.my.sts.model.DeptDao;
import com.my.sts.model.DeptVo;

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
}
