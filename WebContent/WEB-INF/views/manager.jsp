<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false"%>
<html>
	<head>
		<title>Manager Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Manager</h1>

		<c:url var="addAction" value="/manager/add" ></c:url>

		<form:form action="${addAction}" commandName="manager">
			<table>
				<c:if test="${!empty manager.name}">
					<tr>
						<td>
							<form:label path="managerId">
								<spring:message text="Manager ID (Must begin with '0')"/>
							</form:label>
						</td>
						<td>
							<form:input path="managerId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="managerId" />
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
						<c:if test="${!empty manager.name}">
							<input type="submit"
								value="<spring:message text="Edit Manager"/>" />
						</c:if>
						<c:if test="${empty manager.name}">
							<input type="submit"
								value="<spring:message text="Add Manager"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Managers List</h3>
		<c:if test="${!empty listManagers}">
			<table class="tg">
				<tr>
					<th width="80">Manager ID</th>
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
				<c:forEach items="${listManagers}" var="manager">
					<tr>
						<td>${manager.id}</td>
						<td>${manager.username}</td>
						<td>${manager.name}</td>
						<td>${manager.lastName}</td>
						<td>${manager.address}</td>
						<td>${manager.phoneNumber}</td>
						<td>${manager.email}</td>
						<td>${manager.insurance}</td>
						<td><a href="<c:url value='/edit/${manager.managerId}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${manager.managerId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
