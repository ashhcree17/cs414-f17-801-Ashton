<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false"%>
<html>
	<head>
		<title>Trainer Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Trainer</h1>

		<c:url var="addAction" value="/trainer/add" ></c:url>

		<form:form action="${addAction}" commandName="trainer">
			<table>
				<c:if test="${!empty trainer.name}">
					<tr>
						<td>
							<form:label path="trainerId">
								<spring:message text="Trainer ID (Must begin with '0')"/>
							</form:label>
						</td>
						<td>
							<form:input path="trainerId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="trainerId" />
						</td> 
					</tr>
				</c:if>
				<tr>
					<td>
						<form:label path="username">
							<spring:message text="Username"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="username" />
					</td> 
				</tr>
				<tr>
					<td>
						<form:label path="password">
							<spring:message text="Password"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="password" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="name">
							<spring:message text="First Name"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="name" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="lastName">
							<spring:message text="Last Name"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="lastName" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="address">
							<spring:message text="Mailing Address"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="address" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="phoneNumber">
							<spring:message text="Phone Number"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="phoneNumber" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="email">
							<spring:message text="Email Address"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="email" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="insurance">
							<spring:message text="Health Insurance Provider"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="insurance" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty trainer.name}">
							<input type="submit"
								value="<spring:message text="Edit Trainer"/>" />
						</c:if>
						<c:if test="${empty trainer.name}">
							<input type="submit"
								value="<spring:message text="Add Trainer"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Trainers List</h3>
		<c:if test="${!empty listTrainers}">
			<table class="tg">
				<tr>
					<th width="80">Trainer ID</th>
					<th width="120">Username</th>
					<th width="120">First Name</th>
					<th width="120">Last Name</th>
					<th width="120">Mailing Address</th>
					<th width="120">Phone Number</th>
					<th width="120">Email Address</th>
					<th width="120">Health Insurance Provider</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listTrainers}" var="trainer">
					<tr>
						<td>${trainer.trainerId}</td>
						<td>${trainer.username}</td>
						<td>${trainer.name}</td>
						<td>${trainer.lastName}</td>
						<td>${trainer.address}</td>
						<td>${trainer.phoneNumber}</td>
						<td>${trainer.email}</td>
						<td>${trainer.insurance}</td>
						<td><a href="<c:url value='/edit/${trainer.trainerId}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${trainer.trainerId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
