package com.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.dept.model.DeptDao;

public class ListController implements Controller {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setAttribute("list", dao.selectAll());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", deptDao.selectAll());
		mav.setViewName("dept/list");
		return mav;
	}

}
