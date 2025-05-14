package com.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.dept.model.DeptDao;

public class DeleteController implements Controller {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		if("GET".equals(request.getMethod())) {
			mav.addObject("deptno",deptno);
			mav.setViewName("dept/delete");
		}else {
			deptDao.deleteOne(deptno);
			mav.setViewName("redirect:list.do");
		}
		return mav;
	}

}
