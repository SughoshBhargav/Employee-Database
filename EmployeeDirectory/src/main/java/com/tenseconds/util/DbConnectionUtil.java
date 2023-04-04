package com.tenseconds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//to establish the connection and get the connection

public class DbConnectionUtil {
	
	private static Connection connection = null;
	
	
	public static Connection getConnetion() {
		
		if(connection == null) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver started");
				
				try {
					
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cseproject1","root","sush");
					System.out.println("Connection Successful");
					
					/*
					 * server address : jdbc:mysql://localhost:3306/cseproject1
					 * UserName : root
					 * Password : sush
					 */
				} 
				
				catch (SQLException e) {
					System.out.println("Connection Failure");
					
				}
				
			} 
			
			catch (ClassNotFoundException e) {
				System.out.println("Driver Not Found");
			}
		}
			
		return connection;
		
	}
}


/*
 EmployeeController --> doGet() -->EmployeeDAO => DbConnectionUtil -> listofemployees.jsp
			step1::
			utility  class to establish connection with DB
			com.tenSeconds.util.DbConnectionUtil
			 
			
			step2::
			Utility class connection should be used by DAO class
			(Data Access Object) --> Helperclass
			
			step3::
			Need to code an Employeee entity class
			
			step4::
			By using this connection the DAO class should execute select query
			and generate an Arraylist of Employee data
			
			step5::
			Employee controller should get the list from DAO class and pass the same to
			employeeList.jsp
			
			Employee Model Class
			
			EmployeeDAO
			=> use the connection established by DbConnectionUtil
			=> trigger the select query on the respective table
			=> fetch every row as objects
			=> store these objects in ArrayList
			=> return the list of employees to Controller
			
*/
