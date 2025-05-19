package com.my.sts05.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class Ex01Controller {

	@RequestMapping(value = "/ex01.do")
	public ModelAndView ex01() {
		return new ModelAndView("ex01");
	}
	
	@RequestMapping("/ex02.do")
	public String ex02() {
		return "ex01";
	}
	
	@RequestMapping("/ex03.do")
	public View ex03() {
		return new View() {
			
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
//				request.getRequestDispatcher("/WEB-INF/views/ex01.jsp")
//					.forward(request, response);
				response.setContentType(getContentType());
				PrintWriter out = response.getWriter();
				out.println("<h1>hello</h1>");
				out.close();
			}
			
			@Override
			public String getContentType() {
				return "text/plain";
			}
		};
	}
	
	@RequestMapping("/ex04.do")
	public void ex04etc() {
		System.out.println("run ex04.do");
	}
	
	@RequestMapping("/ex05.do")
	public ModelAndView ex05() {
		return null;
	}
	
}






