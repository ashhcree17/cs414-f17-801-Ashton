<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Manager Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
			<table>
				<tr>
					<td><form:label path="id">Manager ID (Must begin with a 0):</form:label></td>
					<td><form:input path="id" value="${manager.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Username:</form:label></td>
					<td><form:input path="name" value="${manager.username}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Password:</form:label></td>
					<td><form:input path="name" value="${manager.password}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">First Name:</form:label></td>
					<td><form:input path="name" value="${manager.name}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Last Name:</form:label></td>
					<td><form:input path="name" value="${manager.lastName}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Address:</form:label></td>
					<td><form:input path="name" value="${manager.address}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Phone Number:</form:label></td>
					<td><form:input path="name" value="${manager.phoneNumber}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Email Address:</form:label></td>
					<td><form:input path="name" value="${manager.email}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Health Insurance Provider:</form:label></td>
					<td><form:input path="name" value="${manager.insurance}"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"/></td>
				</tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty managers}">
			<h2>List Managers</h2>
			<table align="left" border="1">
				<tr>
					<th>Manager ID</th>
					<th>Manager Username</th>
					<th>Manager Password</th>
					<th>Manager First Name</th>
					<th>Manager Last Name</th>
					<th>Manager Address</th>
					<th>Manager Phone Number</th>
					<th>Manager Email Address</th>
					<th>Manager Health Insurance Provider</th>
					<th>Actions on Row</th>
				</tr>
				<c:forEach items="${managers}" var="manager">
					<tr>
						<td><c:out value="${employee.id}"/></td>
						<td><c:out value="${employee.username}"/></td>
						<td><c:out value="${employee.password}"/></td>
						<td><c:out value="${employee.name}"/></td>
						<td><c:out value="${employee.lastName}"/></td>
						<td><c:out value="${employee.address}"/></td>
						<td><c:out value="${employee.phoneNumber}"/></td>
						<td><c:out value="${employee.email}"/></td>
						<td><c:out value="${employee.insurance}"/></td>
						<td align="center"><a href="edit.html?id=${manager.id}">Edit</a> | <a href="delete.html?id=${manager.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
   </body>
</html>