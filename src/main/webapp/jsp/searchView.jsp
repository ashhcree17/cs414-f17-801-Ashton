<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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