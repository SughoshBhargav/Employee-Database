package com.tenseconds.model;

public class Employee {
	
	private int emp_id;
	private String emp_name;
	private String dob;
	private String emp_designation;
	
	//Default Constructor
	
	public Employee() {
		
	}
	
	//Alt + Shift + S --> Generate constructor and fields
	
	public Employee(int emp_id, String emp_name, String dob, String emp_designation) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.dob = dob;
		this.emp_designation = emp_designation;
	}
	
	
	//Alt + Shift + S --> Generate getters and setters
	
	public int getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	public String getEmp_name() {
		return emp_name;
	}
	
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getEmp_designation() {
		return emp_designation;
	}
	
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}

	//Alt + Shift + S --> Generate toString()
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", dob=" + dob + ", emp_designation="
				+ emp_designation + "]";
	}
	
}
