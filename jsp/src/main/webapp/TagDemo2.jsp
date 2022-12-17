<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; 
	charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tag Demo</title>
</head>
<body>
	<h1>This is Tag Demo 2 jsp</h1>
	<%!List<Integer> list = new ArrayList<Integer>();%>
	<%
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	%>
	<%
	for (int num : list) {
	%>
	<%=num%>
	<%
	}
	%>
</body>
</html>