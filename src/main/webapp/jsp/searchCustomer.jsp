<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search for a Customer</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="customer" action="searchCustomer"
		method="get">

		<table>
			<tr>
				<td><form:label path="customerid">Customer Id:</form:label></td>
				<td><form:input path="customerid" name="customerid" id="qualificationid" /></td>
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