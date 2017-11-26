<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form:form method="get" modelAttribute="searchCriteria">
		    <fieldset>
		        <legend>Search Criteria</legend>
		        <table>
		            <tr>
		                <td><form:label path="category">Book Category</form:label></td>
		                <td><form:select path="category" items="${categories}" itemValue="id" itemLabel="name"/></td>
		            </tr>
		        </table>
		    </fieldset>
		    <button id="search">Search</button>
		</form:form>
	</body>
</html>