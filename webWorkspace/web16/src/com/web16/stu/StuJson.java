package com.web16.stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuJson extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("application/json");
		int num=0;
		try {
			num=Integer.parseInt(req.getParameter("num"));
		}catch (Exception e) {
		}
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		
		out.print("{\"stus\":[");
		for(int i=num; i<num+4; i++) {
			if(i!=num)out.print(",");
			out.print("{\"num\":100"+i+",");
			out.print("\"name\":\"user"+(i+1)+"\",");
			out.print("\"kor\":9"+i+",");
			out.print("\"eng\":8"+i+",");
			out.print("\"math\":7"+i+"}");
		}
		out.print("]}");
		out.close();
	}
}









