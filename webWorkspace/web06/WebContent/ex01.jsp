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
<h1>환경변수</h1>
	<h2><%=System.getenv("Oracle_id") %></h2>
	<h2><%=System.getenv("Oracle_pw") %></h2>
<ul>
	<%
	java.util.Map<String,String> map= System.getenv();
	java.util.Set<java.util.Map.Entry<String,String>> set = map.entrySet();
	Iterator<java.util.Map.Entry<String,String>> ite= set.iterator();
	while(ite.hasNext()){
		java.util.Map.Entry<String,String> entry=ite.next();
	%>
	<li><%=entry.getKey() %> - <%=entry.getValue() %></li>
	<%
	}
	%>
</ul>
</body>
</html>






