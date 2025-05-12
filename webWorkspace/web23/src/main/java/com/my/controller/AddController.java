package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myframework.Controller;

public class AddController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		return "bbs/add";
	}

}
