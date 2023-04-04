package com.tenseconds.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tenseconds.dao.EmployeeDAO;
import com.tenseconds.dao.EmployeeDAOImpl;
import com.tenseconds.model.Employee;
import com.tenseconds.util.DbConnectionUtil;

public class EmployeeController extends HttpServlet{
	
	
	Connection connection = null;
	EmployeeDAO employeeDAO = null;
	List<Employee> employeesList = null;
	

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Running doPut()");
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("DoGet function is running");
		
		String name  = req.getParameter("name");
		System.out.println("Name of the enquirer is "+name);
		
//		DbConnectionUtil dbConnectionUtil = new DbConnectionUtil();
//		connection = DbConnectionUtil.getConnetion();
		
//		System.out.println("Driver is up and running");
		
		employeeDAO = new EmployeeDAOImpl();
		employeesList = (List)employeeDAO.getEmployeeList();
		System.out.println(employeesList);
		req.setAttribute("employeesList", employeesList);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/employeeList.jsp");
		dispatcher.forward(req, resp);
//		
		
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		System.out.println("Running doPost()");
//		
//		
//		Employee employee = new Employee();
//		int emp_id = req.getParameter("empID") != null && !req.getParameter("empID").isEmpty() ? Integer.parseInt(req.getParameter("empID")) : 0;
//		employee.setEmp_id(emp_id);
//		employee.setEmp_name(req.getParameter("empName"));
//		employee.setDob(req.getParameter("empDob"));
//		employee.setEmp_designation(req.getParameter("empDesignation"));
//
//		
//		System.out.println(employee); //toString();
//		
//		
//		
//		//FE =>Controler => doPost() => EmployeeDAO => DbConnectionUtil() =>db;
//		
//		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//		
//		if(emp_id != 0 ){
//			if(employeeDAO.updateEmployee(employee,emp_id)) {
//				req.setAttribute("confirmMessage", "Employee Updated");
//			}
//		
//			else {
//				System.out.println("Error in Updating");
//			}
//			
//		}
//		
//		else {
//			if(employeeDAO.saveEmployee(employee)) {
//				req.setAttribute("confirmMessage", "Employee Account Added Successfully");
//			}
//		
//			else {
//				System.out.println("Error in Account Creation");
//			}
//		}
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("views/add-employee.jsp");
//		dispatcher.forward(req, resp);
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getServletPath();

	    switch (action) {
	        case "/EmployeeController":
	            updateEmployee(request, response);
	            break;
	        case "/deleteEmployee":
	            deleteEmployee(request, response);
	            break;
	        default:
	            
	            break;
	    }
	    System.out.println(action);
	}
	
	private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		System.out.println("Runnig doDelete()");
		
		Employee employee = new Employee();
		int emp_id = req.getParameter("empID") != null && !req.getParameter("empID").isEmpty() ? Integer.parseInt(req.getParameter("empID")) : 0;
		
		employee.setEmp_id(emp_id);
		employee.setEmp_name(req.getParameter("empName"));
		employee.setDob(req.getParameter("empDob"));
		employee.setEmp_designation(req.getParameter("empDesignation"));

		
		System.out.println(employee); //toString();
		
		employeeDAO = new EmployeeDAOImpl();
		if(employeeDAO.deleteEmployee(emp_id)) {
			System.out.println("Data Deleted Successfullt");
		}
		
		else
			System.out.println("Error in Deletion");
		
		System.out.println(employeesList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/delete-employee.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("Running doPost()");
		
		
		Employee employee = new Employee();
		int emp_id = req.getParameter("empID") != null && !req.getParameter("empID").isEmpty() ? Integer.parseInt(req.getParameter("empID")) : 0;
		employee.setEmp_id(emp_id);
		employee.setEmp_name(req.getParameter("empName"));
		employee.setDob(req.getParameter("empDob"));
		employee.setEmp_designation(req.getParameter("empDesignation"));

		
		System.out.println(employee); //toString();
		
		
		
		//FE =>Controler => doPost() => EmployeeDAO => DbConnectionUtil() =>db;
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if(emp_id != 0 ){
			if(employeeDAO.updateEmployee(employee,emp_id)) {
				req.setAttribute("confirmMessage", "Employee Updated");
			}
		
			else {
				System.out.println("Error in Updating");
			}
			
		}
		
		else {
			if(employeeDAO.saveEmployee(employee)) {
				req.setAttribute("confirmMessage", "Employee Account Added Successfully");
			}
		
			else {
				System.out.println("Error in Account Creation");
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/add-employee.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
