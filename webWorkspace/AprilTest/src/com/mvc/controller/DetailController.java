package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BoardDao;
import com.mvc.model.BoardDto;

public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		BoardDao dao = new BoardDao();
		BoardDto bean = dao.selectOne(id);

		req.setAttribute("bean", bean);

		RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
	}
}