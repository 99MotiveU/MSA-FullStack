<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>out 내장객체</h1>
<%
out.write("출력1".toCharArray());
out.print("출력2");
out.append("출력3");
out.flush();
out.newLine();
out.println("출력");
%>
</body>
</html>