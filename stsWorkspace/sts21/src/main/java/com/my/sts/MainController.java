package com.my.sts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@Autowired
	DeptDaoImpl deptDao;

	@GetMapping("/")
	public String index() {
		deptDao.createTable();
		return "ok";
	}
}
