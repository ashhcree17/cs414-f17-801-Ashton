<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search Results</title>
	</head>
	<body>
		<form:form id="regForm" modelAttribute="searchView" 
			action="modifyView" method="post">
			<table>
				<tr>
					<td>Search Results for Address</td>
				</tr>
				<tr>
					<td>Id: ${pSearchTerm}</td>
			 		<td>
				 		<button id="button-id" type="submit">
				 			Modify
				 		</button>
				 	</td>	
				</tr>
			</table>
		</form:form>
	</body>
</html>