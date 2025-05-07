package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.BoardDao;

public class DeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		BoardDao dao = new BoardDao();
		if (dao.deleteOne(id) > 0) {
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		resp.sendRedirect("list");
	}
}