package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BbsDao;
import com.mvc.model.BbsDto;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BbsDao dao=new BbsDao();
		List<BbsDto> list=dao.getList();
		req.setAttribute("alist", list);
		req.setAttribute("pageBegin", 10);
		req.setAttribute("pageEnd", 15);
		
		RequestDispatcher rd=req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}
}









