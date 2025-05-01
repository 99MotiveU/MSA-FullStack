package com.web17.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web17.util.Mysql;

public class BbsOneJson extends HttpServlet {
	ResultSet rs;
	Statement stmt;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		String sql="select * from bbs01 where num="+num;
		String json="";
		json="{\"bbs\":[";
		try {
			stmt=Mysql.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				json+="{\"content\":\""+rs.getString("content")+"\",\"num\":"
						+rs.getInt("num")+",\"sub\":\""
					+rs.getString("sub")+"\",\"id\":\""+rs.getString("id")
					+"\",\"nalja\":\""+rs.getDate("nalja")+"\"}";
			}
		}catch (Exception e) {
			try {
				if(Mysql.getConnection()!=null)
					Mysql.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		json+="]}";
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(new String(json.getBytes("utf-8"),"utf-8"));
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		String sub=req.getParameter("sub");
		String content=req.getParameter("content");
		String sql="update bbs01 set sub='"+sub
				+"',content='"+content+"' where num="+num;
		try {
			stmt=Mysql.getConnection().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(Mysql.getConnection()!=null)
					Mysql.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}










