package com.web19.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.MysqlDataSource;

public class BbsDao {
	private DataSource dataSource;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public BbsDao() {
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:33306/xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		this.dataSource=dataSource;
	}
	
	public List<BbsDto> getList() throws SQLException{
		String sql="select * from bbs order by num desc";
		List<BbsDto> list=new ArrayList<BbsDto>();
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
				list.add(new BbsDto(
						rs.getInt("num"),rs.getString("sub")
						,rs.getString("content"),rs.getString("id")
						,rs.getTimestamp("nalja")
						));
		}finally {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}

	public void insertOne(String sub, String id, String content) throws SQLException {
		String sql="insert into bbs (sub,id,content,nalja) values ('"
					+sub+"','"+id+"','"+content+"',now())";
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		}finally {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
	}
}









