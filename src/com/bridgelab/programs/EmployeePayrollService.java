package com.bridgelab.programs;

	import java.io.Reader;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import com.mysql.jdbc.MySQLConnection;

	public class  EmployeePayrollService{
		
		public void readEmployeeData() throws SQLException {
			
			Connection conn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM payroll_service.employee_payroll";
			Statement query = conn.createStatement();
			ResultSet resultSet = query.executeQuery(sql);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String phoneNo = resultSet.getString("phone_number");
				String gender = resultSet.getString("gender");
				System.out.println(id+" "+name+" "+phoneNo+" "+gender);
				
			}
			conn.close();
		}
		
		public void updateEmployeeData(String name, double salary) throws SQLException {
			Connection conn = MySQLConnection.getConnection();
			String sql = String.format("UPDATE `payroll_service`.`employee_payroll` SET BasicPay = %.2f  WHERE name = '%s' ;", salary, name );
			Statement query = conn.createStatement();
			int re = query.executeUpdate(sql);
			
			conn.close();
		}
		
		public static void main(String[] args) throws SQLException {
			EmployeePayrollService services = new EmployeePayrollService();
			services.readEmployeeData();
			services.updateEmployeeData(null, 0);
			services.readEmployeeData();
		}
	}

