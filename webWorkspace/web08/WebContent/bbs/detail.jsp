<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../">[home]</a>
<a href="../bbs/">[bbs]</a>
<a href="../login/">[login]</a>
<hr>
<%@ page import="com.web08.model.*,java.sql.*" %>
<jsp:useBean id="bean" class="com.web08.model.Bbs07Bean"></jsp:useBean>
<jsp:setProperty property="num" name="bean"/>
<%
String sql="select * from bbs07 where num="+bean.getNum();
try(
		Connection conn=MyDb.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		){
	if(rs.next()){
		bean.setSub(rs.getString("sub"));
		bean.setId(rs.getString("id"));
		bean.setContent(rs.getString("content"));
	}
}
%>
<h1>detail page<jsp:getProperty name="bean" property="num"/></h1>
<form action="edit.jsp">
	<input type="hidden" name="num" value="<%=bean.getNum()%>">
	<div><label>sub</label><input name="sub" value="<%=bean.getSub()%>"></div>
	<div><label>id</label><input name="id" value="<%=bean.getId()%>"></div>
	<div><textarea name="content"><%=bean.getContent() %></textarea></div>
	<div><input type="submit" value="수 정"></div>
</form>
</body>
</html>

