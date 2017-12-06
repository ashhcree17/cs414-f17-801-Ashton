<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Address Search</title>
	</head>
	<body>
		<form:form id="regForm" modelAttribute="searchAddress" action="searchView"
					method="post">
		<div class="row">
		     <div class="small-3 columns">
		        <input type="text" id="txt" name="searchTerm">
		      </div>
		
		       <div class="small-5 columns end">
		         <button id="button-id" type="submit">Search Address by Id</button>
		       </div>
		
		   </div>
		</form:form>

		 <div class="row">
		      <div> ${searchTerm} </div>
		</div>
	</body>
</html>