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
String idx=request.getParameter("idx");
Bbs07Dao dao=new Bbs07Dao();
JavaBean bean=dao.selectOne(Integer.parseInt(idx));
%>
<h1>detail page</h1>
<table width="800">
	<tr>
		<td width="100" align="center" bgcolor="gray">글번호</td>
		<td width="50"><%=bean.getNum() %></td>
		<td width="100" align="center" bgcolor="gray">글쓴이</td>
		<td ><%=bean.getId() %></td>
		<td width="100" align="center" bgcolor="gray">날짜</td>
		<td width="100"><%=bean.getNalja() %></td>
	</tr>
	<tr>
		<td width="100" align="center" bgcolor="gray">제목</td>
		<td colspan="5"><%=bean.getSub() %></td>
	</tr>
	<tr>
		<td width="100" bgcolor="gray"></td>
		<td colspan="4" height="300"><%=bean.getContent() %></td>
		<td width="100" bgcolor="gray"></td>	
	</tr>
	<tr>
		<td colspan="6" align="center">
			<a href="edit.jsp?idx=<%=bean.getNum()%>">[수 정]</a>
			<a href="delete.jsp?idx=<%=bean.getNum()%>">[삭 제]</a>
			<a href="readd.jsp?idx=<%=bean.getNum()%>">[답 글]</a>
		</td>
	</tr>
</table>
</body>
</html>













