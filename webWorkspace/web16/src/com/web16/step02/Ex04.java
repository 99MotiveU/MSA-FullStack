package com.web16.step02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex04 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
//		res.setContentType("text/plain");
		ServletOutputStream out = res.getOutputStream();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>test04 page</h1>");
		out.println("<a href='test05?user=admin'>link</a>");
		out.println("<form action=\"test05\" method=\"post\">");
		out.println("<input name=\"user\"/>");
		out.println("<button>send</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
