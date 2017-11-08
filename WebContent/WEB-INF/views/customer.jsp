<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false"%>
<html>
	<head>
		<title>Customer Page</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
			.tg .tg-4eph{background-color:#f9f9f9}
		</style>
	</head>
	
	<body>
		<h1>Add a Customer</h1>

		<c:url var="addAction" value="/customer/add" ></c:url>

		<form:form action="${addAction}" commandName="customer">
			<table>
				<c:if test="${!empty customer.name}">
					<tr>
						<td>
							<form:label path="customerId">
								<spring:message text="Customer ID (Must begin with '2')"/>
							</form:label>
						</td>
						<td>
							<form:input path="customerId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="customerId" />
						</td> 
					</tr>
				</c:if>
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
					<td>
						<form:label path="membership">
							<spring:message text="Membership Status"/>
						</form:label>
					</td>
					<td>
						<!-- This will need to be prepopulated -->
						<form:input path="membership" />
					</td> 
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty customer.name}">
							<input type="submit"
								value="<spring:message text="Edit Customer"/>" />
						</c:if>
						<c:if test="${empty customer.name}">
							<input type="submit"
								value="<spring:message text="Add Customer"/>" />
						</c:if>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<h3>Customers List</h3>
		<c:if test="${!empty listCustomers}">
			<table class="tg">
				<tr>
					<th width="80">Customer ID</th>
					<th width="120">First Name</th>
					<th width="120">Last Name</th>
					<th width="120">Mailing Address</th>
					<th width="120">Phone Number</th>
					<th width="120">Email Address</th>
					<th width="120">Health Insurance Provider</th>
					<th width="120">Membership Status</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listCustomers}" var="customer">
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.name}</td>
						<td>${customer.lastName}</td>
						<td>${customer.address}</td>
						<td>${customer.phoneNumber}</td>
						<td>${customer.email}</td>
						<td>${customer.insurance}</td>
						<td>${customer.membership}</td>
						<td><a href="<c:url value='/edit/${customer.customerId}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${customer.customerId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
