package com.web20.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web20.model.BbsDao;

@WebServlet("/bbs/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BbsDao dao = new BbsDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("list",  dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/bbs/list.jsp").forward(request, response);
		
	}

}
