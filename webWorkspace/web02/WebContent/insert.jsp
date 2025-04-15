<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="0; URL=/web02/list.jsp" />
<title>Insert title here</title>
</head>
<body>
<%
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@172.30.1.128:1521:xe";
String user="scott";
String password="tiger";
String sub=request.getParameter("sub");
String writer=request.getParameter("writer");
String content=request.getParameter("content");
String sql="insert into bbs01 values ((select max(num)+1 from bbs01),'"
			+sub+"','"+content+"','"+writer+"',sysdate)";

Connection conn=null;
Statement stmt=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	int result=stmt.executeUpdate(sql);
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
</body>
</html>








