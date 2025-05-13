package com.my.controller;

import javax.servlet.http.HttpServletRequest;

import com.myframework.Controller;

public class IndexController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		return "index";
	}

}
