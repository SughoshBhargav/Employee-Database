<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Directory | Add Employee</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
		<script>
		
		 function showInput() {
    document.getElementById("inputLabel").style.display = "block";
  }

  function hideInput() {
    document.getElementById("inputLabel").style.display = "none";
  }
		
		</script>
		
	</head>
	
	<body class="text-center">
		<br><h1>Enter Employee Details</h1>
		
		<!-- localhost:8080/EmployeeDirectory/EmployeeController -->
		<!-- 	<c:set var = "myContext" value = "${pageContext.request.contextPath }"></c:set> -->
		<br><br>
		
		
<form>
  <label>
    <input type="radio" name="option" value="ADD EMPLOYEE" onclick="showInput()">EDIT EMP
  </label>
  <label>
    <input type="radio" name="option" value="EDIT EMPLOYEE" onclick="hideInput()">ADD EMP
  </label>
  <br><br>
</form>
		<div class="row	 justify-content-center">
    		<div class="col-auto">
				<form action="${pageContext.request.contextPath}/EmployeeController" method = "post">
					<input id="inputLabel" type = "text" class="form-control" name = "empID" placeholder = "Enter the ID"  / ><br><br>
					<input type = "text" class="form-control" name = "empName" placeholder = "Enter the Name"/><br><br>
					<input type = "date" class="form-control" name = "empDob" placeholder = "Enter the DOB"/><br><br>
					<input type = "text" class="form-control" name = "empDesignation" placeholder = "Enter the Designation"/><br><br>
					<button type = "submit" class="btn btn-success">Save</button>
					<button type= "button" class="btn btn-danger" onclick="window.location.href ='/EmployeeDirectory/index.html'">BACK</button>
					<br><br>
				</form>
			</div>
		</div>	
	</body>
	
</html>