package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("call servlet...");
		String val1 = this.getServletContext().getInitParameter("key1");
//		String val1=this.getInitParameter("param1");
//		String val2=this.getInitParameter("param2");
		PrintWriter out = resp.getWriter();
		out.print("ex01 page ");
		out.print("key1:" + val1 + "<br/>");
		Enumeration<String> enu = this.getInitParameterNames();
		while (enu.hasMoreElements()) {
			String key = enu.nextElement();
			String val = this.getInitParameter(key);
			out.print(key + ":" + val + " ");
		}
//		out.close();
	}
}
