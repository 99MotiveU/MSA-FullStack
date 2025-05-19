package com.my.sts05.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.sts05.dept.model.DeptDao;
import com.my.sts05.dept.model.DeptVo;
import com.my.sts05.dept.service.DeptService;

@Controller
@RequestMapping("/dept/")
public class DeptController {
	@Autowired
	DeptService deptService;

	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("list", deptService.listPage());
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public void add() {}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(int deptno,String dname,String loc) {
		deptService.addPage(new DeptVo(deptno,dname,loc));
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int deptno,Model model) {
		model.addAttribute("bean", deptService.onePage(deptno));
		model.addAttribute("title", "상세");
		return "dept/one";
	}
	
	@RequestMapping(value = "edit",method=RequestMethod.GET)
	public String edit(int deptno,Model model) {
		model.addAttribute("bean", deptService.onePage(deptno));
		model.addAttribute("title", "수정");
		return "dept/one";
	}
	@RequestMapping(value = "edit",method=RequestMethod.POST)
	public String edit(@ModelAttribute DeptVo bean) {
		deptService.editPage(bean);
		return "redirect:list";
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	public String delete(int deptno) {
		deptService.deletePage(deptno);
		return "redirect:list";
	}
}










