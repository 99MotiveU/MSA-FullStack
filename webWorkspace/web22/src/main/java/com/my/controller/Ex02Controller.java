package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/ex02", initParams = { @WebInitParam(name = "param1", value = "AAAA"),
		@WebInitParam(name = "param2", value = "BBBB") })
public class Ex02Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet run...");
		String cntxt1 = this.getServletContext().getInitParameter("key1");

		String val1 = this.getInitParameter("param1");
		String val2 = this.getInitParameter("param2");
		PrintWriter out = resp.getWriter();
		out.println("ex02 page param1:" + val1 + ",param2:" + val2);
		out.println("context param1:" + cntxt1);
		out.close();
	}
}
