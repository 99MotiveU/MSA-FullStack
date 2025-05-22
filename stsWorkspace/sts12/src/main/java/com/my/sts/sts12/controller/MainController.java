package com.my.sts.sts12.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/intro")
	public String intro(Model model) {
		model.addAttribute("msg", "환영합니다");
		model.addAttribute("arr", List.of("item1","item2","item3","item4"));
		return "intro";
	}
}









