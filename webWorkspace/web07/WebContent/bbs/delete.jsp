<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img alt=""
		src="http://www.kibwa.org/data/skin/default/images/da_image/hd_logo.png">
	<a href="../">[HOME]</a>
	<a href="../bbs/">[BBS]</a>
	<a href="../login/">[login]</a>
	<hr>
	<%@ page import="com.bbs07.model.*"%>
	<%
		int num = Integer.parseInt(request.getParameter("idx"));
		Bbs07Dao dao = new Bbs07Dao();
		if ("POST".equals(request.getMethod())) {
			if (dao.deleteOne(num) > 0) {
				response.sendRedirect("./");
				return;
			} else {
				response.sendRedirect("./detail.jsp?idx=" + num);
				return;
			}
		}
	%>
	<h1>delete page</h1>
	<table align="center">
		<tr>
			<td>
				<form action="delete.jsp" method="post">
					<input type="hidden" name="idx" value="<%=num%>"> <input
						type="submit" value="삭 제"> <input type="button"
						value="취 소" onclick="history.back();">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>













