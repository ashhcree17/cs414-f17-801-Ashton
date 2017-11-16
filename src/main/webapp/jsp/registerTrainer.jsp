<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Trainer Registration</title>
	</head>
	<body>
		<form:form id="regForm" modelAttribute="trainer" action="registerTrainerProcess"
			method="post">
			<table>
				<tr>
					<td><form:label path="trainerid">Trainer Id (Must start with 1):</form:label></td>
					<td><form:input path="trainerid" name="trainerid" id="trainerid" /></td>
				</tr>
				<tr>
					<td><form:label path="username">Username</form:label></td>
					<td><form:input path="username" name="username" id="username" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" name="password" id="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button id="register" name="register">Register</form:button></td>
				</tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><a href="home.jsp">Home</a></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>