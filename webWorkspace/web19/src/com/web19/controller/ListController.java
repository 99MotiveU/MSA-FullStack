package com.web19.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web19.model.BbsDao;

public class ListController extends HttpServlet {
	BbsDao dao=new BbsDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setAttribute("list", dao.getList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		RequestDispatcher rd=req.getRequestDispatcher("../list.jsp");
		RequestDispatcher rd=req.getRequestDispatcher("/list.jsp");
		rd.forward(req, resp);
	}
}












