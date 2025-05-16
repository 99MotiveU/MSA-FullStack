package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.my.model.DeptDao;
import com.my.model.DeptDto;

public class EditController extends SimpleFormController {
	@Autowired
	DeptDao deptDao;
	
	@Override
	protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
			throws Exception {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		return new ModelAndView("dept/edit","bean",deptDao.selectOne(deptno));
	}
	
	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response,
			Object command, BindException errors) throws Exception {
		deptDao.updateOne((DeptDto)command);
		return new ModelAndView("redirect:list.do");
	}
}
