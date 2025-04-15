<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스크립트릿</h1>
<%
System.out.println("test");
out.print("<h2>test</h2>");
for(int i=0; i<5; i++){
%>
<h3>test</h3>
<%
System.out.println("test");
}
%>
</body>
</html>