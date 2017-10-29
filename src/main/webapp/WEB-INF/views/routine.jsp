<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false"%>
<html>
	<head>
		<title>Routine Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Routine</h1>

		<c:url var="addAction" value="/routine/add" ></c:url>

		<form:form action="${addAction}" commandName="routine">
			<table>
				<c:if test="${!empty routine.name}">
					<tr>
						<td>
							<form:label path="routineId">
								<spring:message text="Routine ID"/>
							</form:label>
						</td>
						<td>
							<form:input path="routineId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="routineId" />
						</td> 
					</tr>
				</c:if>
				<tr>
					<td>
						<form:label path="name">
							<spring:message text="Name"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="name" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="exercises">
							<spring:message text="Exercises"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="exercises" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty routine.name}">
							<input type="submit"
								value="<spring:message text="Edit Routine"/>" />
						</c:if>
						<c:if test="${empty routine.name}">
							<input type="submit"
								value="<spring:message text="Add Routine"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Routines List</h3>
		<c:if test="${!empty listRoutines}">
			<table class="tg">
				<tr>
					<th width="80">Routine ID</th>
					<th width="120">Name</th>
					<th width="120">Exercises</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listRoutines}" var="routine">
					<tr>
						<td>${routine.routineId}</td>
						<td>${routine.name}</td>
						<td>${routine.exercises}</td>
						<td><a href="<c:url value='/edit/${routine.routineId}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${routine.routineId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
