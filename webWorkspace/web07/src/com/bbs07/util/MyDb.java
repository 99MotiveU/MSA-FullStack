package com.bbs07.util;

import java.sql.Connection;
import java.sql.SQLException;

public class MyDb {

	private static Connection conn;
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "scott";
	private static String password = "tiger";

	private MyDb() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		if (conn == null || conn.isClosed()) {
			Class.forName(driver);
			conn = java.sql.DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
}
