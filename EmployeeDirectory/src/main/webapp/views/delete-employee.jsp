<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	
	<body class="text-center">
	<h1>Delete Employee</h1><br><br>
		<div class="row	 justify-content-center">
    		<div class="col-auto">
				<form action="${pageContext.request.contextPath}/deleteEmployee" method = "post">
					<input id="inputLabel" type = "text" class="form-control" name = "empID" placeholder = "Enter the ID"  / ><br><br>
					<button type = submit class="btn btn-success" onclick="window.location.href ='views/delete-employee.jsp">DELETE</button>
					<button type = "button" class="btn btn-danger" onclick="window.location.href ='/EmployeeDirectory/index.html'">BACK</button>
					<br><br>
				</form>
			</div>
		</div>
	</body>
</html>