package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BbsDao;



public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		
		BbsDao dao=new BbsDao();
		req.setAttribute("bean", dao.selectOne(num));
		req.setAttribute("edit", true);
		
		RequestDispatcher rd=req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		String sub=req.getParameter("sub");
		String content=req.getParameter("content");
		BbsDao dao=new BbsDao();
		dao.editOne(num,sub,content);
		
		resp.sendRedirect("detail.do?num="+num);
	}
}











