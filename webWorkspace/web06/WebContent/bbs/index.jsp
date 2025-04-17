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
	<h1>list page</h1>
	<%@ page import="java.sql.*"%>
	<form action="./">
		<select name="limit">
			<option value="5">5씩</option>
			<option value="10">10씩</option>
			<option value="25">25씩</option>
			<option value="50">50씩</option>
		</select> <input type="submit" value="보기">
	</form>
	<table width="800" border="1" cellspacing="0">
		<tr>
			<th width="50">no</th>
			<th>subject</th>
			<th width="100">nalja</th>
			<th width="50">count</th>
		</tr>
		<%
			int limit = 10;
			try {
				limit = Integer.parseInt(request.getParameter("limit"));
			} catch (Exception e) {
			}
			String p = request.getParameter("p");
			if (p == null)
				p = "1";
			String sql = "select * from " + "    (select rownum as rn,num,sub,nalja,cnt from "
					+ "        (select num,sub,nalja,cnt from bbs05 order by num desc))" + "    where rn BETWEEN 10*("
					+ Integer.parseInt(p) + "-1)+1 and 10*(" + Integer.parseInt(p) + "-1)+1+(10-1)";
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			int loop = 0;
			try {
				Class.forName(DbInfo.driver);
				conn = DriverManager.getConnection(DbInfo.url, DbInfo.user, DbInfo.password);
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select trunc((count(num)-1)/10)+1 from bbs05");
				if (rs.next())
					loop = rs.getInt(1);
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("num")%></td>
			<td><%=rs.getString("sub")%></td>
			<td><%=rs.getDate("nalja")%></td>
			<td><%=rs.getInt("cnt")%></td>
		</tr>
		<%
			}
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
		%>
	</table>
	<p>
		<%
			int barCnt = 10;
			int begin = barCnt * ((Integer.parseInt(p) - 1) / barCnt) + 1;
			int end = begin + (barCnt - 1);
			if (end > loop)
				end = loop;
			if ((Integer.parseInt(p) - 1) / barCnt == 0) {
		%><a>[이전]</a>
		<%
			} else {
		%><a href="./?p=<%=begin - 1%>&limit=<%=limit%>">[이전]</a>
		<%
			}
			for (int i = begin; i <= end; i++) {
		%><a href="./?p=<%=i%>&limit=<%=limit%>">[<%=i%>]
		</a>
		<%
			}
			if (end < loop) {
		%><a href="./?p=<%=end + 1%>&limit=<%=limit%>">[이후]</a>
		<%
			} else {
		%><a>[이후]</a>
		<%
			}
		%>
	</p>
	<a href="add.jsp">[입 력]</a>
</body>
</html>




