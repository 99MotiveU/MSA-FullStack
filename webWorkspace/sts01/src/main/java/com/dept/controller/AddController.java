package com.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.dept.model.DeptDao;
import com.dept.model.DeptDto;

public class AddController implements Controller {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		if("GET".equals(request.getMethod()))
			mav.setViewName("dept/add");
		else if("POST".equals(request.getMethod())){
			request.setCharacterEncoding("utf-8");
			deptDao.insertOne(new DeptDto(
					Integer.parseInt(request.getParameter("deptno"))
					,request.getParameter("dname")
					,request.getParameter("loc")
					));
			
			mav.setViewName("redirect:list.do");
		}
		
		return mav;
	}

}
