package com.my.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener02 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context Listener init");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context Listener dest");

	}

}
