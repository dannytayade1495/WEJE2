<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; 
	charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
String username = request.getParameter("username");
String password = request.getParameter("password");
Connection connection = null;
PreparedStatement preparedStatement = null;
int result = 0;
String driverPath = "com.mysql.cj.jdbc.Driver";
String dburl = "jdbc:mysql://localhost:3306/weje2";
String user = "root";
String pass = "root";
String query = "insert into stud values (?,?,?,?,?,?)";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
	<fieldset>
		<legend>Student Details</legend>
		<table>
			<tr>
				<td><label>ID : </label></td>
				<td><%=id%></td>
			</tr>
			<tr>
				<td><label>Name : </label></td>
				<td><%=name%></td>
			</tr>
			<tr>
				<td><label>Email : </label></td>
				<td><%=email%></td>
			</tr>
			<tr>
				<td><label>Mobile : </label></td>
				<td><%=mobile%></td>
			</tr>
			<tr>
				<td><label>Username : </label></td>
				<td><%=username%></td>
			</tr>
			<tr>
				<td><label>Password : </label></td>
				<td><%=password%></td>
			</tr>
		</table>
	</fieldset>
	<%
	try {
		Class.forName(driverPath);
		connection = DriverManager.getConnection(dburl, user, pass);
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, email);
		preparedStatement.setString(4, mobile);
		preparedStatement.setString(5, user);
		preparedStatement.setString(6, password);
		result = preparedStatement.executeUpdate();
		if (result != 0) {
	%>
	<h3><%=result%> row(s) affected</h3>
	<%
	}
	} catch (Exception e) {
	%>
	<%=e%>
	<%
	}
	%>
</body>
</html>