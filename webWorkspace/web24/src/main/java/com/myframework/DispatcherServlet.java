package com.myframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	Map<String,Controller> handler=new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		Map<String,String> infoMap=new HashMap<>();
		Properties props=new Properties();
		InputStream is;
		try {
//			File f=new File(".");
//			System.out.println(f.getAbsolutePath());
			String propertiesPath=config.getServletContext()
										.getRealPath(".")
										+"\\WEB-INF\\classes\\";
			is = new FileInputStream(propertiesPath+"framework.properties");
			props.load(is);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<Object> keys = props.keys();
		try {
			while(keys.hasMoreElements()) {
				String key=(String) keys.nextElement();
				String val=props.getProperty(key);
				Controller controller=(Controller) Class.forName(val).newInstance();
				handler.put(key,controller);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getRequestURI();
		path=path.substring(req.getContextPath().length());
		Controller controller=handler.get(path);
		if(controller==null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		String info=controller.execute(req);
		if(info==null)return;
		if(info.startsWith("redirect:")) {
			String url=info.substring("redirect:".length());
			resp.sendRedirect(url);
			return;
		}
		String prefix="/WEB-INF/views/";
		String suffix=".jsp";
		String viewName=prefix+info+suffix;
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doDo(req, resp);
	}
}
