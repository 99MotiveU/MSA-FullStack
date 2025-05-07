package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BoardDao;
import com.mvc.model.BoardDto;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int currentPage = 1;
		String keyword = req.getParameter("keyword") != null ? req.getParameter("keyword") : "";

		if (req.getParameter("page") != null) {
			currentPage = Integer.parseInt(req.getParameter("page"));
		}

		BoardDao dao = new BoardDao();
		List<BoardDto> list = dao.getList(currentPage, keyword);

		int totalCount = dao.getTotalCount(keyword);
		int totalPages = (int) Math.ceil(totalCount / 10.0);

		req.setAttribute("boardList", list);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("keyword", keyword);

		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}
}