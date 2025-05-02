package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BbsDao;
import com.mvc.model.BbsDto;


public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		
		BbsDao dao=new BbsDao();
		BbsDto bean=dao.selectOne(num);
		
		req.setAttribute("bean", bean);
		
		RequestDispatcher rd=req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
	}
}









