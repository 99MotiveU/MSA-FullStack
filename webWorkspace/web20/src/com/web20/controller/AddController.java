package com.web20.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web20.model.BbsDao;

@WebServlet(value = "/bbs/add.do")
public class AddController extends HttpServlet {
	BbsDao dao=new BbsDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("login")==null)
			resp.sendRedirect(req.getContextPath()+"/login/signin.do");
		else
		req.getRequestDispatcher("/bbs/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("login")==null) {
			resp.sendRedirect(req.getContextPath()+"/login/signin.do");
			return ;
		}
		String id=(String) session.getAttribute("login");
		String sub=req.getParameter("sub");
		String content=req.getParameter("content");
		try {
			dao.insertOne(sub,content,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("./list.do");
	}
}











