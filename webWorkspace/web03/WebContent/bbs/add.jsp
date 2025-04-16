<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" align="center">
		<tr>
			<td><img alt="logo" src="/web03/imgs/hd_logo.png"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="darkgray"><a href="../">[HOME]</a> <a
				href="../intro.jsp">[INTRO]</a> <a href="./list.jsp">[BBS]</a> <a
				href="../login/login.jsp">[LOGIN]</a></td>
		</tr>
		<tr>
			<td height="400" valign="top">
				<!-- begin --> <%
 	request.setCharacterEncoding("utf-8"); // 반드시 getparameter 전에 해야함(post방식)
 	String subject = "";
 	String id = "";
 	String content = "";
 	if (request.getMethod().equals("POST")) {
 		subject = request.getParameter("subject");
 		id = request.getParameter("id");
 		content = request.getParameter("content");
 		String sql = "insert into bbs02 (num,id,subject,content,nalja) values (" + "bbs02_seq.nextval,'" + id
 				+ "','" + subject + "','" + content + "',sysdate)";

 		String driver = "oracle.jdbc.driver.OracleDriver";
 		String url = "jdbc:oracle:thin:@localhost:1521:xe";
 		String user = "scott";
 		String password = "tiger";

 		Class.forName(driver);
 		java.sql.Connection conn = null;
 		java.sql.Statement stmt = null;
 		int result = 0;
 		try {
 			conn = DriverManager.getConnection(url, user, password);
 			stmt = conn.createStatement();
 			result = stmt.executeUpdate(sql);
 		} catch (Exception e) {

 		} finally {
 			if (stmt != null)
 				stmt.close();
 			if (conn != null)
 				conn.close();
 		}
 		if (result > 0)
 			response.sendRedirect("/web03/bbs/list.jsp");
 	}
 %>
				<h1 align="center">insert page</h1>
				<form action="add.jsp" method="post">
					<table align="center">
						<tr>
							<td width="100" align="center" bgcolor="gray">제목</td>
							<td><input type="text" name="subject" size="40"
								value="<%=subject%>"></td>
						</tr>
						<tr>
							<td bgcolor="gray" align="center">아이디</td>
							<td><input type="text" name="id" value="<%=id%>"></td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="content" cols="50" rows="4"><%=content%></textarea></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="입 력"> <input
								type="reset" value="취 소"></td>
						</tr>
					</table>
				</form> <!-- end -->
			</td>
		</tr>
		<tr>
			<td align="center">
				<hr> <font size="2">
					<p>(06130) 서울 강남구 테헤란로 7길 22, 한국과학기술회관 1관 303호</p>
					<p>&copy;한국IT여성기업인협회 Inc. All Rights Reserved.</p>
			</font>
			</td>
		</tr>

	</table>
</body>
</html>