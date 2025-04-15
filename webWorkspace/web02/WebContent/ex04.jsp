<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단</title>
</head>
<body>
	<table border="1" width="100%">
		<h1>구구단 출력</h1>
		<tr>
		<!--<td>2단</td>
			<td>3단</td>
			<td>4단</td>
			<td>5단</td>
			<td>6단</td>
			<td>7단</td>
			<td>8단</td>
			<td>9단</td>-->		
			<%for(int dan=2; dan<10; dan++){ %>
			<td><%out.print(dan+"단");%></td>	
			<%}%>
		</tr>
		<%
			for (int i = 1; i < 10; i++) {
		%>
		<tr>
			<%for(int dan=2; dan<10; dan++){ %>
			<td><%out.print(dan);%>X<%out.print(i);%>
			=<%out.print(dan*i);%>
			</td>
			<%}%>
		</tr>
		<%}%>
	</table>

</body>
</html>