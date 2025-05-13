package com.my.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.my.model.DeptDao;
import com.my.model.DeptDto;
import com.myframework.Controller;

public class InsertController implements Controller {
	DeptDao dao=new DeptDao();

	@Override
	public String execute(HttpServletRequest req) {
		
		DeptDto bean=new DeptDto(
				Integer.parseInt(req.getParameter("deptno"))
				,req.getParameter("dname")
				,req.getParameter("loc")
				);
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}

}












