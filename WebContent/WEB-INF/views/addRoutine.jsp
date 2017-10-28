<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Routine Form</title>
	</head>
	<body>
		<h2>Add Routine Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
			<table>
				<tr>
					<td><form:label path="id">Routine ID:</form:label></td>
					<td><form:input path="id" value="${routine.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name" value="${routine.name}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Exercises:</form:label></td>
					<!-- ??? Check how to display multiples/table of exercises with edit button -->
					<td><form:input path="name" value="${routine.exercises}"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"/></td>
				</tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty routines}">
			<h2>List routines</h2>
			<table align="left" border="1">
				<tr>
					<th>Routine ID</th>
					<th>Name</th>
					<th>Exercises</th>
					<th>Actions on Row</th>
				</tr>
				<c:forEach items="${routines}" var="routine">
					<tr>
						<td><c:out value="${routine.id}"/></td>
						<td><c:out value="${routine.name}"/></td>
						<td><c:out value="${routine.exercises}"/></td>
						<td align="center"><a href="edit.html?id=${routine.id}">Edit</a> | <a href="delete.html?id=${routine.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
   </body>
</html>