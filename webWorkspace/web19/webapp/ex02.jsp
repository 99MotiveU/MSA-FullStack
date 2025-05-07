<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el의 표현</h1>
	<jsp:useBean id="test1" class="java.util.Date" scope="page"></jsp:useBean>
	<p>
		<%
		int a=1234;
		//pageContext.setAttribute("a", a);
		pageContext.setAttribute("a", 1111);
		request.setAttribute("a", true);
		session.setAttribute("a", 3.14);
		application.setAttribute("a", "문자열");
		
		out.print(pageContext.getAttribute("a"));
		out.print(request.getAttribute("a"));
		out.print(session.getAttribute("a"));
		out.print(application.getAttribute("a"));
		
		// el 우선순위
		//page > request > session > application
		%>
	</p>
	<p>${pageScope.a}</p>
	<p>${requestScope.a }</p>
	<p>${sessionScope.a}</p>
	<p>${applicationScope.a}</p>
</body>
</html>









