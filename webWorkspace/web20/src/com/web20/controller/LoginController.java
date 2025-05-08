package com.web20.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web20.model.UserDao;

@WebServlet(value = "/login/signin.do")
public class LoginController extends HttpServlet {
	UserDao dao=new UserDao();	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login/sign.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		HttpSession session = req.getSession();
	    try {
			session.setAttribute("login", dao.selectOne(id, pw));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath());
	}
}








