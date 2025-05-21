package com.my.sts.dept.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.sts.dept.model.DeptVo;
import com.my.sts.dept.service.DeptService;

@Controller
@RequestMapping("/dept/")
public class DeptController {
	@Autowired
	DeptService deptService;

	@GetMapping("")
	public String list(Model model) {
		deptService.getList(model);
		return "dept/list";
	}
	
	@PostMapping("")
	public String add(@ModelAttribute DeptVo bean) {
		deptService.addList(bean);
		return "redirect:./";
	}
	
	@GetMapping("add")
	public void add() {}
	
	@GetMapping("{deptno}")
	public String detail(@PathVariable int deptno,Model model) {
		deptService.getList(model,deptno);
		return "dept/dept";
	}
	
//	@RequestMapping(value = "{deptno}",method=RequestMethod.PUT)
	@PutMapping("{deptno}")
	public String edit(@PathVariable int deptno,String dname, String loc) {
		deptService.editList(new DeptVo(deptno,dname,loc));
		return "redirect:./";
	}
	
	@DeleteMapping("{deptno}")
	public ResponseEntity<String> delete(@PathVariable int deptno) throws IOException {
		System.out.println("delete param:"+deptno);
		if(deptService.rmList(deptno))
			return new ResponseEntity<String>(HttpStatus.OK);
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}







