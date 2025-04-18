<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="http://www.kibwa.org/data/skin/default/images/da_image/hd_logo.png">
<a href="../">[HOME]</a>
<a href="../bbs/">[BBS]</a>
<a href="../login/">[login]</a>
<hr>
<%@ page import="com.bbs07.model.Bbs07Dao" %>
<%
request.setCharacterEncoding("utf-8");
	if("POST".equals(request.getMethod())){
		String sub=request.getParameter("sub");
		String id=request.getParameter("id");
		String content=request.getParameter("content");
		Bbs07Dao dao=new Bbs07Dao();
		dao.insertOne(sub,id,content);
		response.sendRedirect("./");
		return;  
	}
%>
<h1>add page</h1>
<form action="add.jsp" method="post">
	<div>
		<label>제목</label><input type="text" name="sub">
	</div>
	<div>
		<label>id</label><input type="text" name="id">
	</div>
	<div>
		<textarea rows="5" cols="50" name="content"></textarea>
	</div>
	<div>
		<input type="submit" value="입 력">
		<input type="reset" value="취 소">
		<input type="button" value="뒤 로" onclick="history.back();">
	</div>
</form>
</body>
</html>













