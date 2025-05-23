package com.my.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(value = "/ex02")
public class MyFilter03 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("login"));
		System.out.println("before filter");
		chain.doFilter(request, response);
		System.out.println("after filter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
