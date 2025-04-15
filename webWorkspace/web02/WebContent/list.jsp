<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" border="0" align="center">
	<tr>
		<td colspan="6"><img src="imgs/hd_logo.png"></td>
	</tr>
	<tr>
		<td width="100" bgcolor="gray"></td>
		<td width="150" bgcolor="gray" align="center"><a href="index.jsp">HOME</a></td>
		<td width="150" bgcolor="gray" align="center"><a href="intro.jsp">INTRO</a></td>
		<td width="150" bgcolor="gray" align="center"><a href="list.jsp">BBS</a></td>
		<td width="150" bgcolor="gray" align="center"><a href="guest.jsp">GUEST</a></td>
		<td width="100" bgcolor="gray"></td>
	</tr>
	<tr>
		<td colspan="6" height="400" valign="top">
		<h1>게시글</h1>
		<table border="1" align="center" width="80%">
			<tr>
				<td width="50">글번호</td>
				<td>제목</td>
				<td width="80">글쓴이</td>
				<td width="80">날짜</td>
			</tr>
			<%@page import="java.sql.*" %>
			<%
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@172.30.1.128:1521:xe";
			String user="scott";
			String password="tiger";
			
			String sql="select * from bbs01 order by num desc";
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url,user,password);
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
			%>
			<tr>
				<td><%=rs.getInt(1) %></td>
				<td><%=rs.getString(2) %></td>
				<td><%=rs.getString(4) %></td>
				<td><%=rs.getDate(5) %></td>
			</tr>
			<%
				}
			}finally{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}
			%>
			
		</table>
		<p align="center"><a href="add.jsp">[입력]</a></p>
		</td>
	</tr>
	<tr>
		<td colspan="6" align="center">
		<hr>
		Copyright &copy; 한국IT여성기업인협회 Inc. All rights reserved.
		</td>
	</tr>
</table>
</body>
</html>