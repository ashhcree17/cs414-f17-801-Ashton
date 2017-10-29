<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false""%>
<html>
	<head>
		<title>Equipment Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Equipment</h1>

		<c:url var="addAction" value="/equipment/add" ></c:url>

		<form:form action="${addAction}" commandName="equipment">
			<table>
				<c:if test="${!empty equipment.name}">
					<tr>
						<td>
							<form:label path="equipmentId">
								<spring:message text="Equipment ID"/>
							</form:label>
						</td>
						<td>
							<form:input path="equipmentId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="equipmentId" />
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
						<form:input path="name" />
					</td> 
				</tr>
				<tr>
					<td>
						<form:label path="quantity">
							<spring:message text="Quantity"/>
						</form:label>
					</td>
					<td>
						<form:input path="quantity" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty equipment.name}">
							<input type="submit"
								value="<spring:message text="Edit Equipment"/>" />
						</c:if>
						<c:if test="${empty equipment.name}">
							<input type="submit"
								value="<spring:message text="Add Equipment"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Inventory List</h3>
		<c:if test="${!empty listInventory}">
			<table class="tg">
				<tr>
					<th width="80">Equipment ID</th>
					<th width="120">Name</th>
					<th width="120">Quantity</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listInventory}" var="equipment">
					<tr>
						<td>${equipment.equipmentId}</td>
						<td>${equipment.name}</td>
						<td>${equipment.quantity}</td>
						<td><a href="<c:url value='/edit/${equipment.equipmentId}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${equipment.equipmentId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
