package com.my.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.my.model.DeptDao;
import com.myframework.Controller;

public class ListController implements Controller {
	DeptDao dao=new DeptDao();

	@Override
	public String execute(HttpServletRequest req) {
		try {
			
			req.setAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "bbs/list";
	}

}
