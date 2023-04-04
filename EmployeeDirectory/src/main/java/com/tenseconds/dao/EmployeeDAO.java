package com.tenseconds.dao;

import java.util.List;

import com.tenseconds.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> getEmployeeList();
	
	boolean saveEmployee(Employee e);
	
	boolean updateEmployee(Employee e,int id);
	
	boolean deleteEmployee(int id);

	//EmployeeDAOImpl
	
}
