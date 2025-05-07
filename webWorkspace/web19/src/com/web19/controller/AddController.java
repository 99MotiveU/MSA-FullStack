package com.web19.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web19.model.BbsDao;

public class AddController extends HttpServlet {
	BbsDao dao=new BbsDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String sub=req.getParameter("sub");
		String id=req.getParameter("id");
		String content=req.getParameter("content");
		try {
			dao.insertOne(sub,id,content);
			resp.sendRedirect("list");
			return;
		} catch (SQLException e) {
			
			req.setAttribute("errMsg", e.getLocalizedMessage());
			req.setAttribute("sub", sub);
			req.setAttribute("id", id);
			req.setAttribute("content", content);
			req.getRequestDispatcher("/add.jsp").forward(req, resp);
		}
	}
}








