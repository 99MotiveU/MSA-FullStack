<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" align="center">
	<tr>
		<td><img alt="logo" src="/web03/imgs/hd_logo.png"></td>
	</tr>
	<tr>
		<td align="center" bgcolor="darkgray">
		<a href="../">[HOME]</a>
		<a href="../intro.jsp">[INTRO]</a>
		<a href="./list.jsp">[BBS]</a>
		<a href="../login/login.jsp">[LOGIN]</a>
		</td>
	</tr>
	<tr>
		<td height="400" valign="top">
		<!-- begin -->
		<h1 align="center">bbs page</h1>
		<table border="1" cellspacing="0" align="center" width="80%">
			<tr>
				<th width="50">번호</th>
				<th>제목</th>
				<th width="80">글쓴이</th>
				<th width="80">날짜</th>
			</tr>
			<%
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="scott";//System.getenv("Oracle_id");
String password="tiger";//System.getenv("Oracle_pw");

String sql="select * from bbs02 order by num desc";
Class.forName(driver);

try(
		java.sql.Connection conn=DriverManager.getConnection(url,user,password);
		java.sql.Statement stmt=conn.createStatement();
		java.sql.ResultSet rs=stmt.executeQuery(sql);
		){
			while(rs.next()){
			%>
			<tr>
				<td align="center"><%=rs.getInt("num") %></td>
				<td><a href="detail.jsp?idx=<%=rs.getInt("num") %>"><%=rs.getString("subject") %></a></td>
				<td align="center"><%=rs.getString("id") %></td>
				<td align="center"><%=rs.getDate("nalja") %></td>
			</tr>
			<%
			}
}
			%>
		</table>
		<p align="center"><a href="add.jsp">[입력]</a></p>
		<!-- end -->
		</td>
	</tr>
	<tr>
		<td align="center">
		<hr>
		<font size="2">
		<p>(06130) 서울 강남구 테헤란로 7길 22, 한국과학기술회관 1관 303호</p>
		<p>&copy;한국IT여성기업인협회 Inc. All Rights Reserved.</p>
		</font>
		</td>
	</tr>
	
</table>
</body>
</html>