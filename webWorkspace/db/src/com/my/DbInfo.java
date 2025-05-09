package com.my;

public class DbInfo {
	
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://172.30.1.98:33306:xe";
	public static String user = System.getenv("Oracle_id");
	public static String password = System.getenv("Oracle_pw");
}
