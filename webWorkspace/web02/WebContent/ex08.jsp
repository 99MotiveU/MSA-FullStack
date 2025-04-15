<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex08 page</h1>
	<p>
		method:<%=request.getMethod()%></p>
	<p>
		id:<%=request.getParameter("id")%></p>
	<p>
		pw:<%=request.getParameter("pw")%></p>
	<p>
		sel:<%=request.getParameter("sel")%></p>
	<p>
		ck1:<%=request.getParameter("ck1")%></p>
	<p>
		ck2:<%=request.getParameter("ck2")%></p>
	<p>
		ck3:<%=request.getParameter("ck3")%></p>
	<p>
		ck:
		<%
		String[] arr = request.getParameterValues("ck");
		out.print(java.util.Arrays.toString(arr));
	%>
	</p>
	<p>
		ra:<%=request.getParameter("ra")%></p>
	<%
		java.util.Enumeration arr2 = request.getParameterNames();
		while (arr2.hasMoreElements()) {
			System.out.println(arr2.nextElement());
		}
		java.util.Map<String, String[]> map = request.getParameterMap();
		java.util.Set<String> set = map.keySet();
		java.util.Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			System.out.println(key + ":" + java.util.Arrays.toString(request.getParameterValues(key)));
		}
		System.out.println("-------------------------------");
		java.util.Set<java.util.Map.Entry<String, String[]>> set2 = map.entrySet();
		java.util.Iterator<java.util.Map.Entry<String, String[]>> ite2 = set2.iterator();
		while (ite2.hasNext()) {
			java.util.Map.Entry<String, String[]> entrys = ite2.next();
			System.out.println(entrys.getKey() + ":" + java.util.Arrays.toString(entrys.getValue()));
		}
	%>

</body>
</html>

