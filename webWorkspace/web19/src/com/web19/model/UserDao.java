package com.web19.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class UserDao {
	private DataSource dataSource;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public UserDao() {
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:33306/xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		this.dataSource=dataSource;
	}
	
	public String selectOne(String id,String pw) throws SQLException {
		String sql="select name from xe.user where id='"
					+id+"' and pw='"+pw+"'";
		System.out.println(sql);
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next())
				return rs.getString("name");
		}finally {
			if(conn!=null)conn.close();
		}
		return null;
	}
	
	

}




