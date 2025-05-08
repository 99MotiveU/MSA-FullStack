package com.web20.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web20.model.BbsDao;
import com.web20.model.BbsDto;

@WebServlet(value = "/bbs/detail.do")
public class DetailController extends HttpServlet {
	BbsDao dao=new BbsDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		int num=Integer.parseInt(req.getParameter("num"));
		BbsDto bean=null;
		try {
			bean = dao.selectOne(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(session.getAttribute("login")==null
				|| bean==null
				|| !session.getAttribute("login").toString().equals(bean.getId())
			) {
			resp.sendRedirect("list.do");
			return;
		}
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("/bbs/detail.jsp").forward(req, resp);
	}
}











