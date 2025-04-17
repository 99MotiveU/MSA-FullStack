<%@page import="com.my.DbInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../">[HOME]</a>
<a href="../intro/">[INTRO]</a>
<a href="../bbs/">[BBS]</a>
<a href="../login/">[login]</a>
<hr>
<h1>Add page</h1>
<form action="insert.jsp">
	<div>제목:<input type="text" name="sub"></div>
	<div><textarea rows="5" cols="50" name="content"></textarea></div>
	<div>
		<input type="submit" value="입 력">
		<input type="reset" value="취 소">
	</div>
</form>

</body>
</html>













