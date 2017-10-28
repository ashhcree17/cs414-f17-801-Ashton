<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Equipment Form</title>
	</head>
	<body>
		<h2>Add Equipment Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
			<table>
				<tr>
					<td><form:label path="id">Equipment ID (Must begin with a 0):</form:label></td>
					<td><form:input path="id" value="${Equipment.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name" value="${Equipment.name}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Picture:</form:label></td>
					<td><form:input path="name" value="${Equipment.picture}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Quantity</form:label></td>
					<td><form:input path="name" value="${Equipment.quantity}"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"/></td>
				</tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty Inventory}">
			<h2>List Inventory</h2>
			<table align="left" border="1">
				<tr>
					<th>Equipment ID</th>
					<th>Name</th>
					<th>Picture</th>
					<th>Quantity</th>
					<th>Actions on Row</th>
				</tr>
				<c:forEach items="${Inventory}" var="Equipment">
					<tr>
						<td><c:out value="${Equipment.equipmentId}"/></td>
						<td><c:out value="${Equipment.name}"/></td>
						<td><c:out value="${Equipment.picture}"/></td>
						<td><c:out value="${Equipment.quantity}"/></td>
						<td align="center"><a href="edit.html?id=${Equipment.id}">Edit</a> | <a href="delete.html?id=${Equipment.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
   </body>
</html>