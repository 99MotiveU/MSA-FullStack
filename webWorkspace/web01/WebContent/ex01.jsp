<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex01 page</h1>
	<%
		System.out.println("출력");
		for(int i = 0; i < 5; i++){
			out.println("<p>출력"+ (i+1) + "</p>");
		}
	%>
</body>
</html>