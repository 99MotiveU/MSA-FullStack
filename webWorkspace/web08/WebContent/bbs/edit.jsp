<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*,com.web08.model.MyDb" %>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bean" class="com.web08.model.Bbs07Bean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
String sql="update bbs07 set sub='"+bean.getSub()+"',content='"
				+bean.getContent()+"' where num="+bean.getNum();
try(
		Connection conn=MyDb.getConnection();
		Statement stmt=conn.createStatement();
		){
	stmt.executeUpdate(sql);
}
%>
<jsp:forward page="detail.jsp">
	<jsp:param value="<%=bean.getNum() %>" name="num"/>
</jsp:forward>
</body>
</html>











