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
		<h1>방명록</h1>
		<form action="guestResult.jsp">
			글쓴이<input type="text" name="writer"><br/>
			<textarea rows="5" cols="80" name="content"></textarea>
			<input type="submit" value="작성">
		</form>
			<table border="1" width="100%">
				<tr>
					<td width="80">글쓴이</td>
					<td>내용</td>
					<td width="50">삭제</td>
				</tr>
				<%@page import="java.sql.*" %>
				<%
				String driver="oracle.jdbc.driver.OracleDriver";
				String url="jdbc:oracle:thin:@172.30.1.128:1521:xe";
				String user="scott";
				String password="tiger";
				Connection conn=null;
				Statement stmt=null;
				ResultSet rs=null;
				String sql="select writer,content,idx from guest01 order by idx desc";
				try{
					Class.forName(driver);
					conn=DriverManager.getConnection(url,user,password);
					stmt=conn.createStatement();
					rs=stmt.executeQuery(sql);
					while(rs.next()){
				%>
				<tr>
					<td><%=rs.getString(1) %></td>
					<td><%=rs.getString(2) %></td>
					<td><a href="guestDel.jsp?idx=<%=rs.getInt(3)%>">[삭제]</a></td>
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