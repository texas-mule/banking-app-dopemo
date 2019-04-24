package com.reveture.mohamad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomersImp implements CustomersInterface{
	public List<Customer> getAllCustomer() {
		List<Customer> customers = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = Postgres.getConnection();

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"Customer\";" );
	         while ( rs.next() ) {
	             int id = rs.getInt("Id");
	             Customer customer=new Customer();
	             customer.setFirstName(rs.getString("firstname"));
	             customer.setLastName(rs.getString("lastname"));
	             customer.setUserName(rs.getString("username"));
	             customer.setPassword(rs.getString("Password"));
	             customer.setC_balance(rs.getDouble("checkbalance"));
	             customer.setS_balance(rs.getDouble("savebalance"));
	             customer.setEmployeid(rs.getInt("employeid"));
	             customer.setA_number(rs.getInt("accountnumber"));
	             customers.add(customer);
	             
	            
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

		return customers;
	}
	public void saveApplication(Customer cust) {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = Postgres.getConnection();
			String sql = "INSERT INTO \"Customer\" (firstname, lastname, username, password, checkbalance, savebalance,employeid,accountnumber) VALUES (?,?,?,?,?,?,?,?)";

			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cust.getFirstName());
			stmt.setString(2, cust.getLastName());

			stmt.setString(3, cust.getUserName());
			stmt.setString(4, cust.getPassword());
			stmt.setDouble(5, cust.getC_balance());
			stmt.setDouble(6, cust.getS_balance());
			stmt.setInt(7, cust.getEmployeid());
			stmt.setInt(8,cust.getA_number());
			
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			// then update didn't occur, throw an exception
			try {
				throw new Exception("Insert Customer failed: ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	

}
