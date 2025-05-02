package com.mvc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.util.Mysql;

public class BbsDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public List<BbsDto> getList(){
		List<BbsDto> list=new ArrayList<BbsDto>();
		String sql="select * from bbs order by num desc";
		try {
			conn=Mysql.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
				list.add(new BbsDto(
						rs.getInt("num"),rs.getString("sub")
						,rs.getString("content"),rs.getString("id")
						,rs.getDate("nalja")
						));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void insertOne(String sub,String id,String content) {
		String sql="insert into bbs (sub,id,content,nalja) values ('"
					+sub+"','"+id+"','"+content+"',now())";
		try {
			conn=Mysql.getConnection();
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public BbsDto selectOne(int num) {
		BbsDto bean=null;
		String sql="select * from bbs where num="+num;
		
		try {
			conn=Mysql.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next())
				bean=new BbsDto(
						rs.getInt("num"),rs.getString("sub")
						,rs.getString("content"),rs.getString("id")
						,rs.getDate("nalja")
						);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return bean;
	}
	
	public int editOne(int num,String sub,String content) {
		String sql="update bbs set sub='"+sub
				+"',content='"+content+"' where num="+num;
		try {
			conn=Mysql.getConnection();
			stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int deleteOne(int num) {
		String sql="delete from bbs where num="+num;
		try {
			conn=Mysql.getConnection();
			stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}













