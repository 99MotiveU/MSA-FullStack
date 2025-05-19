package com.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex03Controller {

	@RequestMapping("/ex21.do")
	public String ex1() {
		return "ex01";
	}
}
