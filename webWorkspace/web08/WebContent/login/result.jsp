<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean scope="session" id="login" class="com.web08.model.Bbs07Bean"></jsp:useBean>
<jsp:setProperty property="*" name="login"/>
<%@ page import="java.sql.*,com.web08.model.MyDb" %>
<%
String sql="select count(*) from bbs07 where num="
			+login.getNum()+" and sub='"+login.getSub()+"'";
try(
		Connection conn=MyDb.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		){
	if(rs.next())login.setLvl(rs.getInt(1));
}
response.sendRedirect("../");
%>
</body>
</html>