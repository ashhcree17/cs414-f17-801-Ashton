<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WorkSchedule Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="workSchedule" action="registerWorkScheduleProcess"
		method="post">

		<table>
			<tr>
				<td><form:label path="workScheduleid">Work Schedule Id:</form:label></td>
				<td><form:input path="workScheduleid" name="workScheduleid" id="workScheduleid" /></td>
			</tr>
			<tr>
				<td><form:label path="day">Day (Enter in Following Format: "yyyy-mm-dd")</form:label></td>
				<td><form:input path="day" name="day" id="day" /></td>
			</tr>
			<tr>
				<td><form:label path="startTime">Start Time (Enter in Following Format: "00:00 AM/PM")</form:label></td>
				<td><form:input path="startTime" name="startTime" id="startTime" /></td>
			</tr>
			<tr>
				<td><form:label path="endTime">End Time (Enter in Following Format: "00:00 AM/PM")</form:label></td>
				<td><form:input path="endTime" name="endTime" id="endTime" /></td>
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