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

public class BbsListJson extends HttpServlet{
	Statement stmt=null;
	ResultSet rs=null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql="select * from bbs01 order by num desc";
		String json="";
		
		json="{\"bbs\":[";
		try {
			stmt=Mysql.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				if(!rs.isFirst())json+=",";
				json+="{\"num\":"+rs.getInt("num")+",\"sub\":\""
					+rs.getString("sub")+"\",\"id\":\""+rs.getString("id")
					+"\",\"nalja\":\""+rs.getDate("nalja")+"\"}";
			}
		}catch (Exception e) {
			System.out.println("  ī          Ȯ ο  ");
		}finally {
				try {
					if(Mysql.getConnection()!=null)
						Mysql.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
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
		String sub=req.getParameter("sub");
		String id=req.getParameter("id");
		String content=req.getParameter("content");
		String sql="insert into bbs01 (sub,id,content,nalja) values ('"
					+sub+"','"+id+"','"+content+"',now())";
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







