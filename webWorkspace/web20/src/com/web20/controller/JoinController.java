package com.web20.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web20.model.UserDao;

@WebServlet(value = "/login/join.do")
public class JoinController extends HttpServlet {
	UserDao dao=new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post join...");
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String name=req.getParameter("name");
		try {
			dao.insertOne(id,pw,name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/login/signin.do");
	}
}










