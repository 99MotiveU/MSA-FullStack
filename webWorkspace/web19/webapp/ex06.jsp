<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = "java,web,db,,framework";

		StringTokenizer stt = new StringTokenizer(msg, ",");
		while (stt.hasMoreTokens())
			System.out.println(stt.nextToken());

		request.setAttribute("arr", msg.split(","));
		request.setAttribute("msg", msg);
	%>
	<c:forEach items="${arr }" var="item" varStatus="status">
		<p>${item }- ${status.count }</p>
	</c:forEach>

	<c:forTokens items="${msg }" delims="," var="item2" varStatus="status">
		<p>${item2 }- ${status.count }</p>
	</c:forTokens>

</body>
</html>














