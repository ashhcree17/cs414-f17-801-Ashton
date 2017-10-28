<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer Form</title>
	</head>
	<body>
		<h2>Add Customer Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
			<table>
				<tr>
					<td><form:label path="id">Customer ID (Must begin with a 2):</form:label></td>
					<td><form:input path="id" value="${Customer.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="name">First Name:</form:label></td>
					<td><form:input path="name" value="${Customer.name}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Last Name:</form:label></td>
					<td><form:input path="name" value="${Customer.lastName}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Address:</form:label></td>
					<td><form:input path="name" value="${Customer.address}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Phone Number:</form:label></td>
					<td><form:input path="name" value="${Customer.phoneNumber}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Email Address:</form:label></td>
					<td><form:input path="name" value="${Customer.email}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Health Insurance Provider:</form:label></td>
					<td><form:input path="name" value="${Customer.insurance}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Membership Status:</form:label></td>
					<td><form:input path="name" value="${Customer.membership}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Assigned Routines:</form:label></td>
					<td><form:input path="name" value="${Customer.assignedRoutines}"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"/></td>
				</tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty Customers}">
			<h2>List Customers</h2>
			<table align="left" border="1">
				<tr>
					<th>Customer ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Email Address</th>
					<th>Health Insurance Provider</th>
					<th>Membership Status</th>
					<th>Assigned Routines</th>
					<th>Actions on Row</th>
				</tr>
				<c:forEach items="${Customers}" var="Customer">
					<tr>
						<td><c:out value="${Customer.id}"/></td>
						<td><c:out value="${Customer.username}"/></td>
						<td><c:out value="${Customer.password}"/></td>
						<td><c:out value="${Customer.name}"/></td>
						<td><c:out value="${Customer.lastName}"/></td>
						<td><c:out value="${Customer.address}"/></td>
						<td><c:out value="${Customer.phoneNumber}"/></td>
						<td><c:out value="${Customer.email}"/></td>
						<td><c:out value="${Customer.insurance}"/></td>
						<td><c:out value="${Customer.membership}"/></td>
						<td><c:out value="${Customer.assignedRoutines}"/></td>
						<td align="center"><a href="edit.html?id=${Customer.id}">Edit</a> | <a href="delete.html?id=${Customer.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
   </body>
</html>