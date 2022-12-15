<%@ page language="java" contentType="text/html; 
	charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%!String url = "https://www.google.co.in";%>
	<%response.sendRedirect(url); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tag Demo</title>
</head>
<body>

	<h1>This is Tag Demo 1 jsp</h1>

	<%!int a = 10;%>
	<%!int b = 20;%>
	<%!int c = 0;%>

	<%c = a + b; %>

	<h1><%= c %></h1>

</body>
</html>