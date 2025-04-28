{"stus":[
<%@ page import="java.sql.*" %>
<%
String sql="select * from stu04 order by num desc";
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="scott";
String password="tiger";
Class.forName(driver);
try(
	Connection conn=DriverManager.getConnection(url, user, password);
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
		){
	//boolean begin=true;
	while(rs.next()){
		if(!rs.isFirst()){out.print(',');}
		//if(begin){begin=!begin;}else{out.print(',');}
%>
	{"num":<%=rs.getInt("num") %>
		,"name":"<%=rs.getString("name") %>"
		,"kor":<%=rs.getInt("kor") %>
		,"eng":<%=rs.getInt("eng") %>
		,"math":<%=rs.getInt("math") %>}
<%
	}
}
%>
]}
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
