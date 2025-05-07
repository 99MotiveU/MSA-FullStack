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
		request.setAttribute("msg", "문자열");

		String[] msgs = { "item1", "item2", "item3", "item4" };
		request.setAttribute("msgs", msgs);
		java.util.List list = new java.util.ArrayList();
		list.add("list1");
		list.add("list2");
		list.add("list3");
		list.add("list4");
		request.setAttribute("arr", list);
		java.util.Map map = new java.util.HashMap();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		request.setAttribute("map", map);
	%>
	<p>${msg }</p>
	<ol>
		<li>${msgs[0] }</li>
		<li>${msgs[1] }</li>
		<li>${msgs[2] }</li>
		<li>${msgs[3] }</li>
	</ol>
	<ol>
		<li>${arr[0] }</li>
		<li>${arr[1] }</li>
		<li>${arr[2] }</li>
		<li>${arr[3] }</li>
	</ol>
	<ul>
		<li>${map["key1"] }</li>
		<li>${map["key2"] }</li>
		<li>${map["key3"] }</li>
		<li>${map["key4"] }</li>
	</ul>
	<ul>
		<li>${map.key1}</li>
		<li>${map.key2 }</li>
		<li>${map.key3}</li>
		<li>${map.key4}</li>
	</ul>

</body>
</html>







