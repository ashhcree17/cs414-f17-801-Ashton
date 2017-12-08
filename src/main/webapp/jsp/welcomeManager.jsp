<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome Manager</title>
	</head>
	<body>
		<table>
			<tr>
				<td>Welcome ${name}!</td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td><a href="createTrainer">Create (Hire) Trainer</a></td>
			</tr>
			<tr>
				<td><a href="createCustomer">Create Customer</a></td>
			</tr>
			<tr>
				<td><a href="createEquipment">Create Equipment</a></td>
			</tr>
			<tr>
				<td><a href="createAddress">Create Address</a></td>
			</tr>
			<tr>
				<td><a href="searchAddress">Modify Address</a></td>
			</tr>
			<tr>
				<td><a href="createQualification">Create Qualification</a></td>
			</tr>
			<tr>
				<td><a href="createWorkSchedule">Create Work Schedule</a></td>
			</tr>
			<tr>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</body>
</html>