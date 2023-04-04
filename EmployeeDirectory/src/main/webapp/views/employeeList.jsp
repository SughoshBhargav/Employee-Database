<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Directory | EmployeeList</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body  class="text-center">
		<h1>Employee List Arrived</h1><br>
		
		<div class="row	 justify-content-center">
    		<div class="col-auto">
				<table class="table table-bordered table-hover ">
				<tr class="thead-dark">
			
				<th>Employee Name</th>
				<th>Employee DOB</th>
				<th>Employee Designation</th>
				
			</tr>
			<tr>
			
			<!-- foreach => items = ${employeesList }; var = "employee" -->
			
				<c:forEach items = "${ employeesList}" var = "employee">
					<tr>
						<td><c:out value = "${employee.getEmp_name() }"></c:out></td>
						<td><c:out value = "${employee.getDob() }"></c:out></td>
						<td><c:out value = "${employee.getEmp_designation() }"></c:out></td>	
					</tr>
					
				</c:forEach>
			</tr>
		</table>
		    </div>
  </div>
  <br>
  <button class="btn btn-danger" onclick="window.location ='../EmployeeDirectory/index.html'">BACK</button><br><br>
		
	</body>
</html>