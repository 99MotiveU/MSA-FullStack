package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.my.model.DeptDao;
import com.my.model.DeptDto;

public class InsertController implements Controller {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		deptDao.insertOne(new DeptDto(
				Integer.parseInt(request.getParameter("deptno"))
				,request.getParameter("dname")
				,request.getParameter("loc")
				));
		
		return new ModelAndView("redirect:list.do");
	}

}
