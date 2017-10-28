<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Manager Formg</title>
	</head>
	<body>
		<h2>Add Trainer Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
			<table>
				<tr>
					<td><form:label path="id">Trainer ID:</form:label></td>
					<!-- Below will need to be prepopulated (and locked) with previously entered trainerId -->
					<!-- <td><form:input path="id" value="${Trainer.id}" readonly="true"/></td> -->
				</tr>
				<tr>
					<td><form:label path="name">Username:</form:label></td>
					<!-- Below will need to be prepopulated with previously entered username -->
					<td><form:input path="name" value="${Trainer.username}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Password:</form:label></td>
					<!-- Below will need to be prepopulated with previously entered password -->
					<td><form:input path="name" value="${Trainer.password}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">First Name:</form:label></td>
					<td><form:input path="name" value="${Trainer.name}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Last Name:</form:label></td>
					<td><form:input path="name" value="${Trainer.lastName}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Address:</form:label></td>
					<td><form:input path="name" value="${Trainer.address}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Phone Number:</form:label></td>
					<td><form:input path="name" value="${Trainer.phoneNumber}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Email Address:</form:label></td>
					<td><form:input path="name" value="${Trainer.email}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Health Insurance Provider:</form:label></td>
					<td><form:input path="name" value="${Trainer.insurance}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Qualifications:</form:label></td>
					<td><form:input path="name" value="${Trainer.qualifications}"/></td>
				</tr>
				<tr>
					<td><form:label path="name">Work Schedule:</form:label></td>
					<td><form:input path="name" value="${Trainer.workSchedule}"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"/></td>
				</tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty Trainers}">
			<h2>List Trainers</h2>
			<table align="left" border="1">
				<tr>
					<th>Trainer ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Email Address</th>
					<th>Health Insurance Provider</th>
					<th>Qualifications</th>
					<th>Work Schedule</th>
					<th>Actions on Row</th>
				</tr>
				<c:forEach items="${Trainers}" var="Trainer">
					<tr>
						<td><c:out value="${Trainer.id}"/></td>
						<td><c:out value="${Trainer.username}"/></td>
						<td><c:out value="${Trainer.password}"/></td>
						<td><c:out value="${Trainer.name}"/></td>
						<td><c:out value="${Trainer.lastName}"/></td>
						<td><c:out value="${Trainer.address}"/></td>
						<td><c:out value="${Trainer.phoneNumber}"/></td>
						<td><c:out value="${Trainer.email}"/></td>
						<td><c:out value="${Trainer.insurance}"/></td>
						<td><c:out value="${Trainer.qualificationsr}"/></td>
						<td><c:out value="${Trainer.workSchedule}"/></td>
						<td align="center"><a href="edit.html?id=${Trainer.id}">Edit</a> | <a href="delete.html?id=${Trainer.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
   </body>
</html>