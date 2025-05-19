package com.my.sts05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04Controller {

	@RequestMapping("/{msg1}/{msg2}/ex31.do")
	public String ex01(
			@PathVariable("msg1") String msg
			,@PathVariable String msg2
			,Model model) {
		model.addAttribute("msg",msg);
		model.addAttribute("msg2",msg2);
		return "ex01";
	}
}
