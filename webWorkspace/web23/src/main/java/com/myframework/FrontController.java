package com.myframework;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

	java.util.Map<String, Controller> handlerMapping = new java.util.HashMap<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
//		java.util.Map<String, String> map=new java.util.HashMap<>();
//		map.put("/index", "com.my.controller.IndexController");
//		map.put("/main", "com.my.controller.MainController");
//		map.put("/bbs/list", "com.my.controller.ListController");
//		map.put("/bbs/insert", "com.my.controller.InsertController");

//		Set<Entry<String, String>> set=map.entrySet();
//		Iterator<Entry<String, String>> ite = set.iterator();\
//클래스 내에 정보를 두지 않고 xml로 사용
		
		Enumeration<String> enu = config.getInitParameterNames();
		while (enu.hasMoreElements()) {
			String url = enu.nextElement();
			String val = config.getInitParameter(url);
			try {
				Class clz = Class.forName(val);
				handlerMapping.put(url, (Controller) clz.newInstance());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(req.getContextPath());
		String url = req.getRequestURI();
		url = url.substring(req.getContextPath().length());

		Controller controller = handlerMapping.get(url);
		if (controller == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		String result = controller.execute(req, resp);
		if (result.startsWith("redirect:")) {
			resp.sendRedirect(result.substring("redirect:".length()));
		} else {
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			String viewName = prefix + result + suffix;
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
}
