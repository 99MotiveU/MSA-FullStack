package com.web12.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataBase {
	private static Connection conn;

	private MyDataBase() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (conn == null || conn.isClosed()) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		}
		return conn;
	}
}
