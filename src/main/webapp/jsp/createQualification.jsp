<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Qualification Registration</title>
	</head>
	<body>
		<form:form id="regForm" modelAttribute="qualification" action="createQualificationProcess"
			method="post">
			<table>
				<tr>
					<td><form:label path="qualificationid">Qualification Id:</form:label></td>
					<td><form:input path="qualificationid" name="qualificationid" id="qualificationid" /></td>
				</tr>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" name="name" id="name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button id="register" name="register">Register</form:button></td>
				</tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><a href="welcome">Manager Home</a></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>