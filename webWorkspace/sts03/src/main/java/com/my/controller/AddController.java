package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.my.model.DeptDao;
import com.my.model.DeptDto;

public class AddController implements Controller {
	@Autowired
	DeptDao deptDao;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if("GET".equals(request.getMethod()))
			return new ModelAndView("dept/add");
		deptDao.insertOne(new DeptDto(
				Integer.parseInt(request.getParameter("deptno"))
				,request.getParameter("dname")
				,request.getParameter("loc")
				));
		return new ModelAndView("redirect:list.do");
	}

}
