package com.my.sts05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex06Controller {

	@RequestMapping(value = "/ex51"
			,method = {
					RequestMethod.GET,RequestMethod.POST
					,RequestMethod.PUT,RequestMethod.DELETE
					,RequestMethod.OPTIONS
								}
			,produces = {
					"text/plain"
			}
			)
	public String ex01() {
		return "ex01";
	}
}
