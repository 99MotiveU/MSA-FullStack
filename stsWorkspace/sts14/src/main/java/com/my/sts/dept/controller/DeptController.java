package com.my.sts.dept.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.sts.dept.model.DeptVo;
import com.my.sts.dept.service.DeptService;


@Controller
@RequestMapping("/dept/")
public class DeptController {
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	DeptService deptService;

	@GetMapping("")
	public String list(Model model) {
		deptService.getList(model);
		return new String("dept/list");
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(@ModelAttribute DeptVo bean) {
		deptService.addList(bean);
		return "redirect:./";
	}
	
	@GetMapping("/{deptno}")
	public String detail(@PathVariable int deptno,Model model) {
		log.debug("pathvariable:"+deptno);
		model.addAttribute("bean", deptService.getList(deptno));
		model.addAttribute("readonly", "readonly");
		return "dept/dept";
	}
	
	@PostMapping("/{deptno}")
	public String edit(@PathVariable int deptno,Model model) {
		model.addAttribute("bean",deptService.getList(deptno));
		return "dept/dept";
	}
	
	@PutMapping("/{deptno}")
	public String edit(@PathVariable int deptno,@ModelAttribute DeptVo bean) {
		log.debug("call put:"+bean);
		deptService.setList(bean);
		return "redirect:./";
	}
	
	@DeleteMapping("/{deptno}")
	public ResponseEntity<?> delete(@PathVariable int deptno){
		if(deptService.rmList(deptno))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}







