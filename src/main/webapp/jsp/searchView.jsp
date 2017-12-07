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
			
			<h2>Search Results for Address</h2>
			<div class="row">
				<div class="small-3 columns">
				   Id: ${pSearchTerm}
				</div>
			
				
				<div class="small-3 columns">
				   To modify this address, please re-enter the Id seen above.
				</div>
				<div class="small-3 columns">
				   <input type="text" id="txt" name="pSearchTerm">
				</div>
		
		       <div class="small-5 columns end">
		         <button id="button-id" type="submit">Modify</button>
		       </div>
		   </div>
		</form:form>
	</body>
</html>