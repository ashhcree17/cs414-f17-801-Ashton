<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>All Managers</title>
	</head>
	<body>
		<h1>List Managers</h1>
		<h3><a href="add.html">Add More Managers</a></h3>
		
		<c:if test="${!empty managers}">
			<table align="left" border="1">
				<tr>
					<th>Manager ID</th>
					<th>Manager Username</th>
					<th>Manager Password</th>
					<th>Manager First Name</th>
					<th>Manager Last Name</th>
				</tr>
				<c:forEach items="${managers}" var="manager">
					<tr>
						<td><c:out value="${manager.id}"/></td>
						<td><c:out value="${manager.username}"/></td>
						<td><c:out value="${manager.password}"/></td>
						<td><c:out value="${manager.name}"/></td>
						<td><c:out value="${manager.lastName}"/></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>