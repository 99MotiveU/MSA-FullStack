package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BoardDao;

public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		BoardDao dao = new BoardDao();
		req.setAttribute("bean", dao.selectOne(id));

		RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		BoardDao dao = new BoardDao();
		dao.editOne(id, title, content);

		resp.sendRedirect("detail?id=" + id);
	}

}