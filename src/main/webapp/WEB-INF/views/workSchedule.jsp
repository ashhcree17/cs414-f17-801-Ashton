<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false"%>
<html>
	<head>
		<title>Work Schedule Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Work Schedule</h1>

		<c:url var="addAction" value="/workSchedule/add" ></c:url>

		<form:form action="${addAction}" commandName="workSchedule">
			<table>
				<c:if test="${!empty workSchedule.name}">
					<tr>
						<td>
							<form:label path="workScheduleId">
								<spring:message text="Work Schedule ID (Must begin with '0')"/>
							</form:label>
						</td>
						<td>
							<form:input path="workScheduleId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="workScheduleId" />
						</td> 
					</tr>
				</c:if>
				<tr>
					<td>
						<form:label path="day">
							<spring:message text="Day of the Week"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="day" />
					</td> 
				</tr>
				<tr>
					<td>
						<form:label path="startTime">
							<spring:message text="Start Time"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="startTime" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="endTime">
							<spring:message text="End Time"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="endTime" />
					</td>
				</tr>
				<tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty workSchedule.day}">
							<input type="submit"
								value="<spring:message text="Edit Work Schedule"/>" />
						</c:if>
						<c:if test="${empty workSchedule.day}">
							<input type="submit"
								value="<spring:message text="Add Work Schedule"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Work Schedules List</h3>
		<c:if test="${!empty listWorkSchedules}">
			<table class="tg">
				<tr>
					<th width="80">Work Schedule ID</th>
					<th width="120">Day of the Week</th>
					<th width="120">Start Time</th>
					<th width="120">End Time</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listWorkSchedules}" var="workSchedule">
					<tr>
						<td>${workSchedule.workScheduleId}</td>
						<td>${workSchedule.day}</td>
						<td>${workSchedule.startTime}</td>
						<td>${workSchedule.endTime}</td>
						<td><a href="<c:url value='/edit/${workSchedule.id}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${workSchedule.id}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
