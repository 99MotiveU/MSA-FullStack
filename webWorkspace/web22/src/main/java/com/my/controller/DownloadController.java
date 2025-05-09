package com.my.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/down.do")
public class DownloadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("fname");
		String origin=req.getParameter("origin");
		String path=req.getRealPath("upload");
		
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=\""+origin+"\"");
		File f=new File(path+"\\"+fname);
		ServletOutputStream out = resp.getOutputStream();
		InputStream is=new FileInputStream(f); 
		while(true) {
			int su=is.read();
			if(su==-1)break;
			out.write(su);
		}
		is.close();
		out.close();
	}
}








