<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>response 내장객체</h1>
<%
response.addHeader("me", "abcd");

/*
try(
	java.io.OutputStream os = response.getOutputStream();
	){ os.write("abc".getBytes());
}
*/
	java.io.OutputStream os = null;
try{
	os =response.getOutputStream();
	os.write("abcd".getBytes());
}finally{
	if(os!=null)os.close();
}
%>
</body>
</html>