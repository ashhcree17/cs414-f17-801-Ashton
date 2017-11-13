<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Equipment Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="equipment" action="registerEquipmentProcess"
		method="post">

		<table>
			<tr>
				<td><form:label path="equipmentid">Equipment Id:</form:label></td>
				<td><form:input path="equipmentid" name="equipmentid" id="equipmentid" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:label path="quantity">Quantity</form:label></td>
				<td><form:input path="quantity" name="quantity" id="quantity" /></td>
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