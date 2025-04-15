<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="0; URL=/web02/guest.jsp" />
<title>Insert title here</title>
</head>
<body>
<h1>이동전</h1>
<%
String writer=request.getParameter("writer");
String content=request.getParameter("content");
String sql="insert into guest01 values (guest01_seq.nextval,'"
				+writer+"','"+content+"')";
System.out.println(sql);
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@172.30.1.128:1521:xe";
String user="scott";
String password="tiger";
java.sql.Connection conn=null;
java.sql.Statement stmt=null;
try{
	Class.forName(driver);
	conn=java.sql.DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	stmt.execute(sql);
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
</body>
</html>






