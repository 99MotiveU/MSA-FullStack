<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*,com.my.*" %>
	<%
	String sub=request.getParameter("sub");
	String content=request.getParameter("content");
	String sql="insert into bbs05 (sub,content,cnt) values ('"+sub+"','"+content+"',0)";
	Connection conn=null;
	Statement stmt=null;
	try{
		Class.forName(DbInfo.driver);
		conn=DriverManager.getConnection(DbInfo.url,DbInfo.user,DbInfo.password);
		stmt=conn.createStatement();
		int result=stmt.executeUpdate(sql);
		response.sendRedirect("./");
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	%>
</body>
</html>








