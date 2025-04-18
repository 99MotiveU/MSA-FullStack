<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bean" class="com.web08.model.Bbs07Bean"></jsp:useBean>
<jsp:setProperty property="sub" name="bean"/>
<jsp:setProperty property="id" name="bean"/>
<jsp:setProperty property="content" name="bean"/>
<%@page import="java.sql.*,com.web08.model.*" %>
<%
String url="add.html";
if("POST".equals(request.getMethod())){
String sql="insert into bbs07 (num,ref,sub,content,id) values (bbs07_seq.nextval,bbs07_seq.currval,'"
			+bean.getSub()+"','"+bean.getContent()+"','"+bean.getId()+"')";
try(
		Connection conn=MyDb.getConnection();
		Statement stmt=conn.createStatement();
		){
	stmt.executeUpdate(sql);
}
url="./";
}
%>
<jsp:forward page="<%=url %>"></jsp:forward>
</body>
</html>









