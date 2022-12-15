<%@ page language="java" contentType="text/html;
	 charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
	<fieldset>
		<legend>Student Form</legend>
		<form action="./StudentDetails.jsp" method="get">
			<table>
				<tr>
					<td><label>ID</label></td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><label>Name</label></td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td><label>Mobile</label></td>
					<td><input type="text" name="mobile"></td>
				</tr>
				<tr>
					<td><label>Username</label></td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="Submit"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>