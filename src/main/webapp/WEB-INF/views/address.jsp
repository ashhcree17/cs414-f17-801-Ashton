<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false"%>
<html>
	<head>
		<title>Address Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Address</h1>

		<c:url value="/address/add" ></c:url>

		<form:form method = "POST" commandName = "address">
			<table>
				<c:if test="${!empty address.addressId}">
					<tr>
						<td>
							<form:label path="addressId">
								<spring:message text="Address ID"/>
							</form:label>
						</td>
						<td>
							<form:input path="addressId" />
						</td> 
					</tr>
				</c:if>
				<tr>
					<td>
						<form:label path="street1">
							<spring:message text="Primary Street"/>
						</form:label>
					</td>
					<td>
						<form:input path="street1" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="street2">
							<spring:message text="Secondary Street"/>
						</form:label>
					</td>
					<td>
						<form:input path="street2" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="city">
							<spring:message text="City"/>
						</form:label>
					</td>
					<td>
						<form:input path="city" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="state">
							<spring:message text="State"/>
						</form:label>
					</td>
					<td>
						<form:input path="state" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="zipCode">
							<spring:message text="Zip Code"/>
						</form:label>
					</td>
					<td>
						<form:input path="zipCode" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty address.name}">
							<input type="submit"
								value="<spring:message text="Edit Address"/>" />
						</c:if>
						<c:if test="${empty address.name}">
							<input type="submit"
								value="<spring:message text="Add Address"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Addresses List</h3>
		<c:if test="${!empty listAddresses}">
			<table class="tg">
				<tr>
					<th width="80">Address ID</th>
					<th width="120">Primary Street</th>
					<th width="120">Secondary Street</th>
					<th width="120">City</th>
					<th width="120">State</th>
					<th width="120">Zip Code</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listAddresses}" var="address">
					<tr>
						<td>${address.addressId}</td>
						<td>${address.street1}</td>
						<td>${address.street2}</td>
						<td>${address.city}</td>
						<td>${address.state}</td>
						<td>${address.zipCode}</td>
						<td><a href="<c:url value='/edit/${address.addressId}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${address.addressId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
