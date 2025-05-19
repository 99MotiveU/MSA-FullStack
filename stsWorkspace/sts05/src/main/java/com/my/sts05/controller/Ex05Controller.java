package com.my.sts05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.sts05.dept.model.DeptVo;

@Controller
public class Ex05Controller {

	@RequestMapping("/ex41.do")
	public void ex41() {}
	
	@RequestMapping("/ex42.do")
	public void ex42(@ModelAttribute("bean") DeptVo bean) {
		System.out.println(bean);
	}
}









