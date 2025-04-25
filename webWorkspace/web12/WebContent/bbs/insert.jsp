<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bean" class="com.web12.model.Bbs05Dto"></jsp:useBean>
<jsp:setProperty property="sub" name="bean"/>
<jsp:setProperty property="content" name="bean"/>
<%@ page import="java.sql.*,com.web12.util.*" %>
<%
if("GET".equals(request.getMethod())){
	response.sendRedirect("add.jsp");
}else{
	try{
		Statement stmt=MyDataBase.getConnection().createStatement();
		stmt.executeUpdate(
"insert into bbs05 (num,sub,content,cnt,nalja) values (bbs05_seq.nextval,'"
+bean.getSub()+"','"+bean.getContent()+"',0,sysdate)"
				);
	}finally{
		if(MyDataBase.getConnection()!=null)MyDataBase.getConnection().close();
		response.sendRedirect("./");
	}
}

%>
</body>
</html>




