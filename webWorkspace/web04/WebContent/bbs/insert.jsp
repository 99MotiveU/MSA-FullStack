<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//get - tomcat get 한글 깨짐
// server.xml << URIEncoding="utf-8" 
//post
//request.setCharacterEncoding("utf-8");
String subject=request.getParameter("subject");
String id=request.getParameter("id");
String content=request.getParameter("content");

String sql="insert into bbs02 (id,nalja,subject,content) values ('"
			+id+"',now(),'"+subject+"','"+content+"')";

String driver="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/xe";
String user="scott";
String password="tiger";
Connection conn=null;
Statement stmt=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url,user,password);
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









