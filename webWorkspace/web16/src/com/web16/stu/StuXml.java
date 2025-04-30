package com.web16.stu;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;

public class StuXml extends HttpServlet {

	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		resp.setContentType("application/xml");
		PrintWriter out = resp.getWriter();
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<stus>");
		for(int i=0; i<5; i++) {
			out.println("<stu>");
			out.println("<num>"+(1000+i)+"</num>");
			out.println("<name>user"+(1+i)+"</name>");
			out.println("<kor>"+(90+i)+"</kor>");
			out.println("<eng>"+(80+i)+"</eng>");
			out.println("<math>"+(70+i)+"</math>");
			out.println("</stu>");
		}
		out.println("</stus>");
		out.close();
	}
	
}
