<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내장 객체</h1>
<%
String addr1=request.getRemoteAddr();
out.print("<p>client ip:"+addr1+"</p>");

int port1 = request.getRemotePort();
out.print("<p>client port:"+port1+"</p>");

String addr2 = request.getServerName();
out.print("<p>Server ip:" + addr2+"</p>");

int port2 = request.getServerPort();
out.print("<p>pserver port:"+port2+"</p>");

String method = request.getMethod();
out.print(method); // get post

String path = request.getContextPath();
String url = request.getRequestURI();
String query = request.getQueryString();
out.print(path+"<br>");
out.print(url+"<br>");
out.print(query+"<br>");
%>
</body>
</html>