<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" border="0" align="center">
	<tr>
		<td colspan="6"><img src="imgs/hd_logo.png"></td>
	</tr>
	<tr>
		<td width="100" bgcolor="gray"></td>
		<td width="150" bgcolor="gray" align="center"><a href="index.jsp">HOME</a></td>
		<td width="150" bgcolor="gray" align="center"><a href="intro.jsp">INTRO</a></td>
		<td width="150" bgcolor="gray" align="center"><a href="list.jsp">BBS</a></td>
		<td width="150" bgcolor="gray" align="center"><a href="guest.jsp">GUEST</a></td>
		<td width="100" bgcolor="gray"></td>
	</tr>
	<tr>
		<td colspan="6" height="400" valign="top">
		<h1>게시판 등록</h1>
		<form action="insert.jsp">
		<table width="80%" align="center">
			<tr>
				<td bgcolor="gray">제목</td>
				<td><input type="text" name="sub" size="55"></td>
			</tr>
			<tr>
				<td bgcolor="gray">글쓴이</td>
				<td><input type="text" name="writer" size="55"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" cols="55" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성"></td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
	<tr>
		<td colspan="6" align="center">
		<hr>
		Copyright &copy; 한국IT여성기업인협회 Inc. All rights reserved.
		</td>
	</tr>
</table>
</body>
</html>