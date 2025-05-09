package com.my.config;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//import org.apache.catalina.core.ApplicationContextFacade;

public class MyListener01 implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestListener destroy");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(sre.getServletRequest());
	}

}
