<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<stus>
	<%@ page import="java.sql.*" %>
	<%
	String sql="select * from stu04 order by num";
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	Class.forName(driver);
	try(
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			){
		while(rs.next()){
	%>
	<stu>
		<num><%=rs.getInt("num") %></num>
		<name><%=rs.getString("name") %></name>
		<kor><%=rs.getInt("kor") %></kor>
		<eng><%=rs.getInt("eng") %></eng>
		<math><%=rs.getInt("math") %></math>
	</stu>
	<%
		} 
	} 
	%>
</stus>