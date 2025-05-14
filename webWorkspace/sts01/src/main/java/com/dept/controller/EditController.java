package com.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.dept.model.DeptDao;
import com.dept.model.DeptDto;

public class EditController implements Controller {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		String viewName="redirect:list.do";
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		if("GET".equals(request.getMethod())) {
			viewName="dept/edit";
			mav.addObject("bean",deptDao.selectOne(deptno));
		}else {
			String dname=request.getParameter("dname");
			String loc=request.getParameter("loc");
			DeptDto bean=new DeptDto(deptno,dname,loc);
			deptDao.updateOne(bean);
		}
		mav.setViewName(viewName);
		return mav;
	}

}
