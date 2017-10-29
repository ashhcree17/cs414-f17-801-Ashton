<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false"%>
<html>
	<head>
		<title>Exercise Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Exercise</h1>

		<c:url var="addAction" value="/exercise/add" ></c:url>

		<form:form action="${addAction}" commandName="exercise">
			<table>
				<c:if test="${!empty exercise.name}">
					<tr>
						<td>
							<form:label path="exerciseId">
								<spring:message text="Exercise ID (Must begin with '0')"/>
							</form:label>
						</td>
						<td>
							<form:input path="exerciseId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="exerciseId" />
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
						<form:label path="duration">
							<spring:message text="Duration"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="duration" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="numberOfSets">
							<spring:message text="Number Of Sets"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="numberOfSets" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="repsPerSet">
							<spring:message text="Repetitions Per Set"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="repsPerSet" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty exercise.name}">
							<input type="submit"
								value="<spring:message text="Edit Exercise"/>" />
						</c:if>
						<c:if test="${empty exercise.name}">
							<input type="submit"
								value="<spring:message text="Add Exercise"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Exercises List</h3>
		<c:if test="${!empty listExercises}">
			<table class="tg">
				<tr>
					<th width="80">Exercise ID</th>
					<th width="120">Name</th>
					<th width="120">Duration</th>
					<th width="120">Number Of Sets</th>
					<th width="120">Repetitions Per Set</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listExercises}" var="exercise">
					<tr>
						<td>${exercise.id}</td>
						<td>${exercise.name}</td>
						<td>${exercise.duration}</td>
						<td>${exercise.numberOfSets}</td>
						<td>${exercise.repsPerSet}</td>
						<td><a href="<c:url value='/edit/${exercise.exerciseId}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${exercise.exerciseId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
