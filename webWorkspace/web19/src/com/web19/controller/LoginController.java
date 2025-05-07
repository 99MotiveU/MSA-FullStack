package com.web19.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web19.model.UserDao;

public class LoginController extends HttpServlet {
	UserDao dao=new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		try {
			String name=dao.selectOne(id, pw);
			
			// 계속 저장 (로그인된 브라우저 로그아웃 전까지)
			// 접속당 한개의 (서버의)메모리 공간
			// 기본 시간 30분이 지나면 자동 갱신
			HttpSession session=req.getSession();
//			System.out.println(session.getId());
//			session.setMaxInactiveInterval(10);
			session.setAttribute("login", name);
//			ServletContext application = req.getServletContext();
//			application.setAttribute("login", name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("../");
	}
}







