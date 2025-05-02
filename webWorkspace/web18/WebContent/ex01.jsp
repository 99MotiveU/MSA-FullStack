<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex01 page</h1>
	<% System.out.println("ex01 run..."); %>
	<jsp:forward page="ex02.jsp"></jsp:forward>
</body>
</html>