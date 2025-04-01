package com.pm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Ex02 {

	public static void main(String[] args) {
		String sql="select deptno, dname, loc from dept order by deptno asc";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Properties props=new Properties();
		props.setProperty("user", "scott");
		props.setProperty("password", "tiger");

		Connection conn=null;
		Statement stmt=null;
		java.sql.ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, props);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getObject(1)+"\t");
				System.out.print(rs.getObject(2)+"\t");
				System.out.println(rs.getObject(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	}

}





