package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.Driver;

public class Mysql {
	static Logger logger=Logger.getLogger(Mysql.class.getCanonicalName());
	private static Connection conn;
	private static String driver=Driver.class.getCanonicalName();
	private static String url="jdbc:mysql://localhost:33306/xe";
	private static String user="scott";
	private static String password="tiger";
	
	private Mysql() {
	}
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,"jar파일 확인");
		}
		if(conn==null || conn.isClosed())
			conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
}






