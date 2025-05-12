package com.my.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyData {
	private static Connection conn;
	
	private MyData() {}
	
	public static Connection getConnection() throws SQLException {
		if(conn==null || conn.isClosed())
		conn = DriverManager.
//	            getConnection("jdbc:h2:~/test", "sa", "");
			getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		return conn;
	}
}
