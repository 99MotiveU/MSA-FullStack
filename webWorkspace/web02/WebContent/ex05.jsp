<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단</title>
</head>
<body>
	<table>
<%!
String setTr(String msg){
	return "<tr>"+msg+"</tr>";
}
String setTd(String msg){
	return "<td>"+msg+"</td>";
}
String gugu(int dan, int i){
	return dan+"x"+i+" = "+(dan*i);
}
%>

	<%
	for(int i=1; i<10; i++){
//		out.print("<tr>");
		String msg="";
		for(int dan = 2; dan<10; dan++){
//			out.print("<td>"+dan+"X"+i+" = "+(dan*i)+"</td>");
			msg +=setTd(gugu(dan,i));
		}
//		out.print("</td>");
		String result = setTr(msg);
		out.print(result);
	}
	%>
</table>
</body>
</html>