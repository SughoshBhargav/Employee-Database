package com.tenseconds.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.tenseconds.model.Employee;
import com.tenseconds.util.DbConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	
	List<Employee> employeesList = new ArrayList<Employee>();
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Employee employee = null;
	
	
	@Override
	public List<Employee> getEmployeeList() {
		
		connection = DbConnectionUtil.getConnetion();
		
		String selectQuery = "SELECT * FROM EMPLOYEEDIRECTORY;";
		
		try {
			
			statement = connection.createStatement();
			System.out.println("Statement object created");
			
			resultSet = statement.executeQuery(selectQuery);
			System.out.println("ResultSetObtained");
			
			while(resultSet.next()) {
				employee = new Employee(resultSet.getInt("emp_id"),resultSet.getString("emp_name"), resultSet.getString("emp_dob"), resultSet.getString("emp_designation"));
				System.out.println(employee); //employee.toString();
				
				employeesList.add(employee);
				
			}
		}
		catch(SQLException e) {
			System.out.println("Statement object not created thus ResultSet not obtained");
		}
	
		return employeesList;
	}


	@Override
	public boolean saveEmployee(Employee e) {

		connection = DbConnectionUtil.getConnetion();
		
		String insertQuery = "INSERT INTO EMPLOYEEDIRECTORY (emp_name,emp_dob,emp_designation) VALUES ('"+e.getEmp_name()+"','"+e.getDob()+"','"+e.getEmp_designation()+"');";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			System.out.println("PS object created");
			
			preparedStatement.executeUpdate(insertQuery); //returns int value 1,0,-1
			System.out.println("Row inserted");
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			System.out.println("PS object not created");
		}
		
		return true;
	}
	
	public boolean updateEmployee(Employee e,int id){

		connection = DbConnectionUtil.getConnetion();
		
		String updateQuery = "UPDATE EMPLOYEEDIRECTORY SET emp_name = '"+e.getEmp_name()+"', emp_dob = '"+e.getDob()+"', emp_designation = '"+e.getEmp_designation()+"' WHERE emp_id = " + id;

		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			System.out.println("PS object created");
			
			preparedStatement.executeUpdate(updateQuery); //returns int value 1,0,-1
			System.out.println("Row updated");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("PS object not created");
		}
		return true;
	}


	@Override
	public boolean deleteEmployee(int id) {
		
		System.out.println("running delete operation");
		
		connection = DbConnectionUtil.getConnetion();
		
		String deleteQuery = "DELETE FROM EMPLOYEEDIRECTORY WHERE emp_id = " + id;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			System.out.println("PS object created");
			
			preparedStatement.executeUpdate(deleteQuery); //returns int value 1,0,-1
			System.out.println("Row deleted");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("PS object not created");
		}
		return true;
	}
}
	
