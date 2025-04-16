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
		<%

String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="scott";
String password="tiger";

String num=request.getParameter("idx");
if("POST".equals(request.getMethod())){
String sql="delete from bbs02 where num="+num;
java.sql.Connection conn=null;
java.sql.Statement stmt=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	int result=stmt.executeUpdate(sql);
	if(result>0)response.sendRedirect("list.jsp");
	return;
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
}

		%>
		<h1 align="center"><%=num %>번 글을 삭제 하시겠습니까?</h1>
		<table align="center">
		<tr><td>
		<form action="delete.jsp" method="post">
			<input type="hidden" name="idx" value="<%=num %>">
			<input type="submit" value="삭 제">
			<input type="button" value="뒤 로" onclick="history.back();">
		</form>
		</td></tr>
		</table>
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