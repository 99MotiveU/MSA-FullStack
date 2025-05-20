package com.my.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.sts.model.DeptVo;
import com.my.sts.service.DeptService;

@Controller
@RequestMapping("/dept/")
public class DeptController {

	@Autowired
	DeptService deptService;
	
	@RequestMapping("")
	public String list(Model model) {
		deptService.selectAll(model);
		return "dept/list";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public void add() {}
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String add(@ModelAttribute DeptVo bean) {
		deptService.addOne(bean);
		return "redirect:./";
	}
}









