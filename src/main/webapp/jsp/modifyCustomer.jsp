<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="customer" action="registerCustomerProcess"
		method="post">

		<table>
			<tr>
				<td><form:label path="customerid">Customer Id (Must start with 2):</form:label></td>
				<td><form:input path="customerid" name="customerid" id="customerid" />${customerid} </td>
			</tr>
			<tr>
				<td><form:label path="name">First Name</form:label></td>
				<td><form:input path="name" name="name" id="name" />${name} </td>
			</tr>
			<tr>
				<td><form:label path="lastname">Last Name</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" />${lastname} </td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" />${email} </td>
			</tr>
			<tr>
				<td><form:label path="insurance">Health Insurance Provider</form:label></td>
				<td><form:input path="insurance" name="insurance" id="insurance" />${insurance} </td>
			</tr>
			<tr>
				<td><form:label path="phonenumber">Phone Number</form:label></td>
				<td><form:input path="phonenumber" name="phonenumber" id="phonenumber" />${phonenumber} </td>
			</tr>
			<tr>
				<td><form:label path="membership">Membership Status</form:label></td>
				<td><form:input path="membership" name="membership" id="membership" />${membership} </td>
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