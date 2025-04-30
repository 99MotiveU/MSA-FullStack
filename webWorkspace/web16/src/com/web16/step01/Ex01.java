package com.web16.step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex01 implements Servlet{
	ServletConfig config;

	@Override
	public void destroy() {
		System.out.println("WAS 컨테이너 종료시 servlet 컨테이너 종료");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return "이 서블릿은 누가 언제 무슨 목적으로 만들었다....";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		System.out.println("servlet객체 생성 시점");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//System.out.println("요청 service...");
		res.setContentType("text/html; charset=UTF-8");
//		res.setContentType("text/plain");
		ServletOutputStream out = res.getOutputStream();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf=8\">");
		out.println("</head>");
		out.println("<body>");
		out.write("<h1>한글로 작성</h1>".getBytes("utf-8"));
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	
	
}












