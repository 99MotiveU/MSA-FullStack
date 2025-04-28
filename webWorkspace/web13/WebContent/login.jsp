<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("id");
String pw=request.getParameter("pw");
System.out.println(id);
System.out.println(pw);
%>
<p>관리자님 로그인 중...</p>
</body>
</html>