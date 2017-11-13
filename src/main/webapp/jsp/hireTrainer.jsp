<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainer Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="trainer" action="hireTrainerProcess"
		method="post">

		<table>
			<tr>
				<td><form:label path="trainerid">Trainer Id (Must start with 1):</form:label></td>
				<td><form:input path="trainerid" name="trainerid" id="trainerid" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">First Name</form:label></td>
				<td><form:input path="firstname" name="firstname" id="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">Last Name</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="insurance">Health Insurance Provider</form:label></td>
				<td><form:input path="insurance" name="insurance" id="insurance" /></td>
			</tr>
			<tr>
				<td><form:label path="phonenumber">Phone Number</form:label></td>
				<td><form:input path="phonenumber" name="phonenumber" id="phonenumber" /></td>
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