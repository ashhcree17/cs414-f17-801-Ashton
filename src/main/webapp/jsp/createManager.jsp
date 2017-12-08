<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<style type="text/css">
			h2 {
				background-color: #c7c7c7;
			    font-family:Arial, sans-serif;
			    font-size:34px;
			    text-align: center;
			    padding:10px 5px;
			    border-style:solid;
			    border-width:1px;
			    overflow:hidden;
			    word-break:normal;
			    border-color:#ccc;
			    color:#333;
			}
			
			body {
			    background-color: #f0f0f0;
			    font-family:Arial, sans-serif;
			    font-size:14px;
			    font-weight:normal;
			    padding:10px 5px;
			    overflow:hidden;
			    word-break:normal;
			    color:#333;
			    border:none;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Manager Registration</title>
	</head>
	<body>
		<form:form id="regForm" modelAttribute="manager" action="createManagerProcess"
			method="post">
			<table>
				<tr>
					<td><form:label path="managerid">Manager Id (Must start with 0):</form:label></td>
					<td><form:input path="managerid" name="managerid" id="managerid" /></td>
				</tr>
				<tr>
					<td><form:label path="username">Username</form:label></td>
					<td><form:input path="username" name="username" id="username" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" name="password"
							id="password" /></td>
				</tr>
				<tr>
					<td><form:label path="name">First Name</form:label></td>
					<td><form:input path="name" name="name" id="name" /></td>
				</tr>
				<tr>
					<td><form:label path="lastname">Last Name</form:label></td>
					<td><form:input path="lastname" name="lastname" id="lastname" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" name="email" id="email" /></td>
				</tr>
				<tr>
					<td><form:label path="insurance">Health Insurance Provider</form:label></td>
					<td><form:input path="insurance" name="insurance" id="insurance" /></td>
				</tr>
				<tr>
					<td><form:label path="phonenumber">Phone Number</form:label></td>
					<td><form:input path="phonenumber" name="phonenumber" id="phonenumber" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button id="register" name="register">Register</form:button></td>
				</tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><a href="home.jsp">Home</a></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>