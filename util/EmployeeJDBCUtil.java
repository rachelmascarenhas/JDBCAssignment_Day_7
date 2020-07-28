package com.montran.util;
import com.montran.pojo.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.montran.main.EmployeeJDBCMain;
public class EmployeeJDBCUtil {
	//private List<Employee> employeeList = new ArrayList<Employee>();
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "montran";
	String password = "montran";
	String sql = "";
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	private Connection connection=null;
	EmployeeJDBCUtil util = new EmployeeJDBCUtil();
	

	
 		    
 		    public boolean addNewEmployee(Employee employee) {
 		        sql = "insert into employee_master values(?,?,?)";
 				   try {
 					
 					preparedStatement = connection.prepareStatement(sql);
 					preparedStatement.setInt(1, employee.getEmployeeId());
 					preparedStatement.setString(2, employee.getName());
 					preparedStatement.setDouble(3, employee.getSalary());
 					preparedStatement.executeUpdate();
 					return true;
 					
 				    } catch (SQLException e) {
 					// TODO Auto-generated catch block
 					return false;
 				}
 				
 			}
 			
 			public boolean addAllEmployees(int numberOfEmployees,Employee employee) {
 				for(int i=0;i<=numberOfEmployees;i++) {
 				     addNewEmployee(employee);
 				}
 			   return true;
 			}

 			
 			public boolean getEmployeeByEmployeeId(int employeeId) {
 				sql = "select * from employee_master where employeeId=?";

 					try {
 						
 						preparedStatement = connection.prepareStatement(sql);
 						preparedStatement.setInt(1,employeeId );
 						resultSet = preparedStatement.executeQuery();

 						while (resultSet.next()) {
 							System.out.println("Employee Id :: " + resultSet.getInt("employee_id"));
 							System.out.println("Name :: " + resultSet.getString("name"));
 							System.out.println("Salary :: " + resultSet.getDouble("salary"));
 							System.out.println("----------------------------------------");
 						}
 						preparedStatement.executeUpdate();
 						return true;
 						
 					} catch (SQLException e) {
 						// TODO Auto-generated catch block
 						return false;
 					}
 					
 				
 			  }
 			
 		    public boolean updateEmployeeSalary(int employeeId ,  double newSalary) {
 		    	sql = "update employee_master set salary=? where employee_id=?";
 		    	try {
 					preparedStatement = connection.prepareStatement(sql);
 					preparedStatement.setDouble(1,newSalary);
 					preparedStatement.setInt(2,employeeId );

 					preparedStatement.executeUpdate();
 					return true;
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					return false;
 				}
 				
 				
 		    		   
 			}
 		    
 		    public boolean deleteEmployee(int employeeId) {
 		    	sql = "delete from employee_master where employee_id = ?";
 		    	try {
 					preparedStatement = connection.prepareStatement(sql);
 					preparedStatement.setInt(1,employeeId);
 					preparedStatement.executeUpdate();
 					return true;
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					return false;
 				}
 		    	
 		    	
 		    }
 		    
 		    
 			public boolean getAllEmployees() {
 				sql = "select * from employee_master order by employee_id";
 				try {
 					preparedStatement = connection.prepareStatement(sql);
 					resultSet = preparedStatement.executeQuery();

 					
						while (resultSet.next()) {
							System.out.println("Employee Id :: " + resultSet.getInt("employee_id"));
							System.out.println("Name :: " + resultSet.getString("name"));
							System.out.println("Salary :: " + resultSet.getDouble("salary"));
							System.out.println("----------------------------------------");
						}
					
 					preparedStatement.executeUpdate();
 					return true;
 					} catch (SQLException e) {
						// TODO Auto-generated catch block
 						return false;
						
						
					}

 				
	
	
	
 			}
}		
	

