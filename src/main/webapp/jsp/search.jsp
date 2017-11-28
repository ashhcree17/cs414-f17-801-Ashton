<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search</title>
	</head>
	<body>
		<form:form method="post" action="searchProcess">
			<table align="center">
				<tr>
					<td><form:label path="username">Username: </form:label></td>
					<td><form:input path="username" name="username" id="username" /></td>
					
					<td>
						<form:label path="searchText" name="searchText" id="searchText">
							Enter Search Term
						</form:label>
					</td>
					<td><form:button id="search" name="search">Search</form:button></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>