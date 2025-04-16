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
request.setCharacterEncoding("utf-8");
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="scott";
String password="tiger";

String num=request.getParameter("idx");
String id="";
String subject="";
String nalja="";
String content="";
String sql="select id,subject,nalja,content from bbs02 where num="+num;
java.sql.Connection conn=null;
java.sql.Statement stmt=null;
java.sql.ResultSet rs=null;
if("GET".equals(request.getMethod())){
	try{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,password);
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs.next()){
			id=rs.getString("id");
			subject=rs.getString("subject");
			nalja=rs.getDate("nalja").toString();
			content=rs.getString("content");
		}
	}finally{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}else{

	subject=request.getParameter("subject");
	content=request.getParameter("content");
	sql="update bbs02 set subject='"+subject+"', content='"
				+content+"', nalja=sysdate where num="+num;
	
	try{
		conn=DriverManager.getConnection(url,user,password);
		stmt=conn.createStatement();
		int result=stmt.executeUpdate(sql);
		if(result>0) response.sendRedirect("detail.jsp?idx="+num);
		return;
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}
		%>
		<h1 align="center"><%=num %>번 page</h1>
		<form action="edit.jsp" method="post">
		<table align="center" width="80%">
			<input type="hidden" name="idx" value="<%=num %>">
			<tr>
				<td width="100" align="center" bgcolor="gray">제목</td>
				<td colspan="3"><input type="text" name="subject" value="<%=subject %>"></td>
			</tr>
			<tr>
				<td width="100" align="center" bgcolor="gray">글쓴이</td>
				<td><%=id %></td>
				<td width="100" align="center" bgcolor="gray">날짜</td>
				<td width="150"><%=nalja %></td>
			</tr>
			<tr>
				<td colspan="4" height="300"><textarea name="content" cols="50" rows="4"><%=content %></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수 정">
					<input type="reset" value="취 소">
				</td>
			</tr>
		</table>
		</form>
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