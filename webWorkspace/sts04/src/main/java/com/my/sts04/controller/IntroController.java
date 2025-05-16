package com.my.sts04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.sts04.DeptDao;

@Controller
public class IntroController{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	DeptDao deptDao;

	@RequestMapping("/intro")
	public ModelAndView intro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("intro");
	}
	
	@RequestMapping("/ex02")
	public ModelAndView ex02(HttpServletResponse response){
		System.out.println(response);
		return new ModelAndView("ex02");
	}
	@RequestMapping("/ex03")
	public String ex03(HttpServletRequest request){
		System.out.println(request.getMethod());
		return "ex03";
	}
	@RequestMapping("/ex04")
	public String ex04(String id,int su) {
		System.out.println(id);
		System.out.println(su);
		deptDao.func01();
		return "ex04";
	}

}
