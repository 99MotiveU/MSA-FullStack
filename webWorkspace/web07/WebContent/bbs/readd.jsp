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
<%@ page import="com.bbs07.model.*" %>
<%
request.setCharacterEncoding("utf-8");
Bbs07Dao dao=new Bbs07Dao();
JavaBean bean=null;
int num=Integer.parseInt(request.getParameter("idx"));
	if("POST".equals(request.getMethod())){
		int ref = Integer.parseInt(request.getParameter("ref"));
		int ord = Integer.parseInt(request.getParameter("ord"));
		int lvl = Integer.parseInt(request.getParameter("lvl"));
		String sub = request.getParameter("sub");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		dao.insertOne(sub, id, content, num, ref, ord, lvl);	
		response.sendRedirect("./");
		return;  
	}else{
		bean=dao.selectOne(num);
	}
%>
<h1>add<%=num %> page</h1>
<form action="readd.jsp" method="post">
<input type = "hidden" name = "num" value="<%=num%>">
<input type = "hidden" name = "ref" value="<%=bean.getRef()%>">
<input type = "hidden" name = "ord" value="<%=bean.getOrd()%>">
<input type = "hidden" name = "lvl" value="<%=bean.getLvl()%>">
	<div>
		<label>제목</label><input type="text" name="sub" value="re:<%=bean.getSub()%>">
	</div>
	<div>
		<label>id</label><input type="text" name="id">
	</div>
	<div>
		<textarea rows="5" cols="50" name="content"><br><br><br><hr><%=bean.getContent() %></textarea>
	</div>
	<div>
		<input type="submit" value="입 력">
		<input type="reset" value="취 소">
		<input type="button" value="뒤 로" onclick="history.back();">
	</div>
</form>
</body>
</html>













