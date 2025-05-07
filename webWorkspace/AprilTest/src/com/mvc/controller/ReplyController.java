package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BoardDao;

public class ReplyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("reply.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String userId = req.getParameter("userId");

		int groupId = Integer.parseInt(req.getParameter("groupId"));
		int orderInGroup = Integer.parseInt(req.getParameter("orderInGroup"));
		int depth = Integer.parseInt(req.getParameter("depth"));

		BoardDao dao = new BoardDao();
		dao.insertReply(title, content, userId, groupId, orderInGroup, depth);

		resp.sendRedirect("list");
	}
}