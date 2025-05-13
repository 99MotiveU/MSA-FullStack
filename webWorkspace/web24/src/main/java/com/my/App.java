package com.my;

import java.io.File;
import java.io.IOException;

//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.util.resource.FileResource;
//import org.eclipse.jetty.util.resource.Resource;
//import org.eclipse.jetty.webapp.WebAppContext;


public class App {

	public static void main(String[] args) throws IOException {
		String cmd="cmd.exe D:\\utils\\apache-maven-3.9.9\\bin\\mvn.cmd jetty:run";
//		String cmd="explorer https://m.naver.com";
		Process process = Runtime.getRuntime().exec(cmd);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		process.destroy();
		
		
		
//		Server server=new Server(8080);
//		WebAppContext ctxt = new WebAppContext();
//		ctxt.setContextPath("/jsp");
//		ctxt.setResourceBase("./jsp/");
//		ctxt.setInitParameter("dirAllowed", "false"); 
//		ctxt.setContextPath("/");
//		File f=new File("src\\main\\webapp");
//		Resource base=new FileResource(f);
//		ctxt.setBaseResource(base);
//		server.setHandler(ctxt);
//		try {
//			server.start();
//		} catch (Exception e) {
//			System.out.println("서버구동 실패");
//		}
	}

}
