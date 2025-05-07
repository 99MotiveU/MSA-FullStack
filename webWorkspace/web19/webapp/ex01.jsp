<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 100%;
}

th {
	width: 25%;
}
</style>
</head>
<body>
	<h1>el language(EL 표현식)</h1>
	<table>
		<tr>
			<th>자료형</th>
			<th>자바</th>
			<th>EL Lang</th>
			<th>etc</th>
		</tr>
		<tr>
			<td>숫자(10진수 정수)</td>
			<td><%=1234%></td>
			<td>${1234 }</td>
			<td></td>
		</tr>
		<tr>
			<td>숫자(10진수 실수)</td>
			<td><%=3.14%></td>
			<td>${3.14 }</td>
			<td></td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%="문자열"%></td>
			<td>${"문자열" }</td>
			<td></td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%='a' + 1%></td>
			<td>${'a' }</td>
			<td></td>
		</tr>
		<tr>
			<td>boolean</td>
			<td><%=true%></td>
			<td>${true }</td>
			<td></td>
		</tr>
		<tr>
			<td>boolean</td>
			<td><%=false%></td>
			<td>${false }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(+)</td>
			<td><%=1 + 2 + 3 + 4 + 5%></td>
			<td>${1+2+3+4+5 }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(-)</td>
			<td><%=6 - 2%></td>
			<td>${6-2 }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(*)</td>
			<td><%=6 * 2%></td>
			<td>${6*2 }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(/)</td>
			<td><%=5 / 2%></td>
			<td>${5/2 }</td>
			<td>${5 div 2 }</td>
		</tr>
		<tr>
			<td>사칙연산(%)</td>
			<td><%=5 % 2%></td>
			<td>${5%2 }</td>
			<td>${5 mod 2 }</td>
		</tr>
		<tr>
			<td>사칙연산(/)</td>
			<td><%=6 / 2 == 3%></td>
			<td>${6/2==3 }</td>
			<td></td>
		</tr>
		<tr>
			<td>비교<</td>
			<td><%=5 < 3%></td>
			<td>${5<3 }</td>
			<td>${5 lt 3 }</td>
		</tr>
		<tr>
			<td>비교></td>
			<td><%=5 > 3%></td>
			<td>${5>3 }</td>
			<td>${5 gt 3 }</td>
		</tr>
		<tr>
			<td>비교==</td>
			<td><%=5 == 3%></td>
			<td>${5==3 }</td>
			<td>${5 eq 3 }</td>
		</tr>
		<tr>
			<td>비교<=</td>
			<td><%=5 < 3%></td>
			<td>${5<=3 }</td>
			<td>${5 le 3 }</td>
		</tr>
		<tr>
			<td>비교>=</td>
			<td><%=5 > 3%></td>
			<td>${5>=3 }</td>
			<td>${5 ge 3 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5 < 3%></td>
			<td>${5<3 }</td>
			<td></td>
		</tr>
		<jsp:useBean id="d" class="java.util.Date"></jsp:useBean>
		<%
			d = null;
			pageContext.setAttribute("d", null);
		%>
		<tr>
			<td>NULL</td>
			<td><%=d == null%></td>
			<td>${d}</td>
			<td>${d eq null }</td>
		</tr>
	</table>
</body>
</html>