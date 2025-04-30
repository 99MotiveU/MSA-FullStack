package com.web16.step02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05 extends GenericServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param=req.getParameter("user");
		res.setContentType("text/html; charset=UTF-8");
//		res.setContentType("text/plain");
		ServletOutputStream out = res.getOutputStream();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ex05 page</h1>");
		out.println("<p>user:"+param+"</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		
		if("POST".equals(request.getMethod())) {
			doPost(request,response);
		}else if("GET".equals(request.getMethod())) {
			doGet(request,response);
		}
		
		

	}

}
