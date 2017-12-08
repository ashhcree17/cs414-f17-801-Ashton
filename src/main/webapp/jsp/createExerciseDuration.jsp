<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<style type="text/css">
			h2 {
				background-color: #c7c7c7;
			    font-family:Arial, sans-serif;
			    font-size:34px;
			    text-align: center;
			    padding:10px 5px;
			    border-style:solid;
			    border-width:1px;
			    overflow:hidden;
			    word-break:normal;
			    border-color:#ccc;
			    color:#333;
			}
			
			body {
			    background-color: #f0f0f0;
			    font-family:Arial, sans-serif;
			    font-size:14px;
			    font-weight:normal;
			    padding:10px 5px;
			    overflow:hidden;
			    word-break:normal;
			    color:#333;
			    border:none;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exercise Registration</title>
	</head>
	<body>
		<form:form id="regForm" modelAttribute="exercise" action="createExerciseDurationProcess"
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
					<td><form:input path="numberOfSets" name="numberOfSets" id="numberOfSets" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="repsPerSet">Repetitions per Set</form:label></td>
					<td><form:input path="repsPerSet" name="repsPerSet" id="repsPerSet" readonly="true" /></td>
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