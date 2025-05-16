package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.my.model.DeptDao;

public class DeleteController implements Controller {
	DeptDao deptDao;
	
	@Autowired
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		deptDao.deleteOne(deptno);
		return new ModelAndView("redirect:list.do");
	}

}
