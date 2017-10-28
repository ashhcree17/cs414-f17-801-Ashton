<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exercise Form</title>
	</head>
	<body>
		<h2>Add Exercise Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
			<table>
				<tr>
					<td><form:label path="id">Exercise ID:</form:label></td>
					<td><form:input path="id" value="${Exercise.exerciseId}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name" value="${Exercise.name}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Duration:</form:label></td>
					<td><form:input path="name" value="${Exercise.duration}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Number of Sets:</form:label></td>
					<td><form:input path="name" value="${Exercise.numberOfSets}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Repetitions Per Set:</form:label></td>
					<td><form:input path="name" value="${Exercise.repsPerSet}"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"/></td>
				</tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty Exercises}">
			<h2>List Exercises</h2>
			<table align="left" border="1">
				<tr>
					<th>Exercise ID</th>
					<th>Name</th>
					<th>Duration</th>
					<th>Number of Sets</th>
					<th>Repetitions per Set</th>
					<th>Actions on Row</th>
				</tr>
				<c:forEach items="${Exercises}" var="Exercise">
					<tr>
						<td><c:out value="${Exercise.id}"/></td>
						<td><c:out value="${Exercise.name}"/></td>
						<td><c:out value="${Exercise.duration}"/></td>
						<td><c:out value="${Exercise.numberOfSets}"/></td>
						<td><c:out value="${Exercise.repsPerSet}"/></td>
						<td align="center"><a href="edit.html?id=${Exercise.id}">Edit</a> | <a href="delete.html?id=${Exercise.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
   </body>
</html>