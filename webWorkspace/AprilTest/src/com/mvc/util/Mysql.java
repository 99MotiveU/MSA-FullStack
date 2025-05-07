package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Mysql {
	private static Connection conn;
	private static String driver = Driver.class.getCanonicalName();
	private static String url = "jdbc:mysql://localhost:33306/xe";
	private static String user = "scott";
	private static String password = "tiger";
	
	private Mysql() {}
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}