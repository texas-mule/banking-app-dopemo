package com.reveture.mohamad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImp implements EmployeeImpDb {
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = Postgres.getConnection();

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"Employees\";" );
	         while ( rs.next() ) {
	             int id = rs.getInt("Id");
	             Employee employee= new Employee();
	             employee.setFirstname(rs.getString("firstname"));
	             employee.setLastname(rs.getString("lastname"));
	             employee.setUsername(rs.getString("username"));
	             employee.setPassword(rs.getString("Password"));
	             employee.setEmployeeid(rs.getInt("employeid"));
	             employees.add(employee);
	             
	            
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employees;
	}

}
