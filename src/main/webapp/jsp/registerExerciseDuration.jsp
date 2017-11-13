<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exercise Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="exercise" action="registerExerciseDurationProcess"
		method="post">

		<table>
			<tr>
				<td><form:label path="exerciseid">Exercise Id:</form:label></td>
				<td><form:input path="exerciseid" name="exerciseid" id="exerciseid" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:label path="duration">Duration</form:label></td>
				<td><form:input path="duration" name="duration" id="duration" /></td>
			</tr>
			<tr>
				<td><form:label path="numberOfSets">Number of Sets</form:label></td>
				<td><form:input path="numberOfSets" name="numberOfSets" id="numberOfSets" /></td>
			</tr>
			<tr>
				<td><form:label path="repsPerSet">Repetitions per Set</form:label></td>
				<td><form:input path="repsPerSet" name="repsPerSet" id="repsPerSet" /></td>
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