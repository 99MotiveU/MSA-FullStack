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
Bbs07Dao dao=new Bbs07Dao();
JavaBean bean=null;
bean=dao.selectOne(Integer.parseInt(request.getParameter("idx")));
%>
<h1>edit page</h1>
<form>
<table width="800">
	<tr>
		<td width="100" align="center" bgcolor="gray">글번호</td>
		<td width="50"><input type="text" name="num" value="<%=bean.getNum() %>" readonly="readonly"></td>
		<td width="100" align="center" bgcolor="gray">글쓴이</td>
		<td ><%=bean.getId() %></td>
		<td width="100" align="center" bgcolor="gray">날짜</td>
		<td width="100"><%=bean.getNalja() %></td>
	</tr>
	<tr>
		<td width="100" align="center" bgcolor="gray">제목</td>
		<td colspan="5"><input type="text" name="sub" value="<%=bean.getSub() %>"></td>
	</tr>
	<tr>
		<td width="100" bgcolor="gray"></td>
		<td colspan="4" height="300"><textarea rows="5" cols="50" name="content"><%=bean.getContent() %></textarea></td>
		<td width="100" bgcolor="gray"></td>	
	</tr>
	<tr>
		<td colspan="6" align="center">
			<input type="submit" value="수 정">
			<input type="reset" value="취 소">
			<input type="button" value="뒤 로" onclick="history.back();">
		</td>
	</tr>
</table>
</form>
</body>
</html>
