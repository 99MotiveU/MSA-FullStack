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
		java.util.Set list = new java.util.HashSet();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		list.add("item5");
		java.util.Map map = new java.util.HashMap();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		request.setAttribute("map", map);
	%>
	<h1>loop</h1>
	<jsp:useBean id="bean" class="com.web19.model.BbsDto" scope="page"></jsp:useBean>
	<jsp:setProperty property="id" name="bean" value="admin" />
	<c:set target="${bean }" property="sub">한글</c:set>
	<c:set target="${bean }" property="num">1234</c:set>
	<c:set target="${bean }" property="content">한글로</c:set>
	<p>${bean.num }</p>
	<p>${bean.sub }</p>
	<p>${bean.content }</p>
	<p>${bean.id }</p>
	<p>${bean.nalja }</p>
	<ul>
		<c:forEach items="${map }" var="item">
			<li>${item.key }:${item.value }</li>
		</c:forEach>
	</ul>
</body>
</html>








