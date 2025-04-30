package com.web16.step03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("user");
		resp.setContentType("text/html; charset=UTF-8");
//		res.setContentType("text/plain");
		ServletOutputStream out = resp.getOutputStream();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ex06 page</h1>");
		out.println("<p>user:"+param+"</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}










