package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BbsDao;

public class AddController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String sub=req.getParameter("sub");
		String id=req.getParameter("id");
		String content=req.getParameter("content");
		
		if(id.isEmpty()) {
			req.setAttribute("sub",sub);
			req.setAttribute("content",content);
			req.setAttribute("errId","¾ÆÀÌµð ºóÄ­");
			doGet(req, resp);
			return;
		}
			
		
		BbsDao dao=new BbsDao();
		dao.insertOne(sub,id,content);
		
		resp.sendRedirect("list.do");
	}
}








