package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractFormController;

import com.my.model.DeptDao;
import com.my.model.DeptDto;

public class InsertController extends AbstractFormController {
	@Autowired
	DeptDao deptDao;

	@Override
	protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
			throws Exception {
		System.out.println("showForm");
		return new ModelAndView("dept/add","errs",errors.getAllErrors());
	}
	
	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {
		//		System.out.println(command);
//		System.out.println(errors);
		DeptDto bean=(DeptDto) command;
		if(bean.getDname().isEmpty()) {
		ObjectError error=new ObjectError("dnameErr", "dname이 비었음");
		errors.addError(error);
		}
	}

	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response,
			Object command, BindException errors) throws Exception {
		System.out.println(errors);
		if(errors.getErrorCount()==0) {
			deptDao.insertOne((DeptDto)command);
			return new ModelAndView("redirect:list.do");
		}
		return showForm(request,response,errors);
	}

	
	
	
}
