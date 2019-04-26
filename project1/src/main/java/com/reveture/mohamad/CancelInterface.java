package com.reveture.mohamad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CancelInterface implements Cinterface{
	public List<Customer> getAllCAccounts() {
		List<Customer> customers = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = Postgres.getConnection();

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"Cancelled\";" );
	         while ( rs.next() ) {
	             int id = rs.getInt("Id");
	             Customer customer=new Customer();
	             customer.setFirstName(rs.getString("firstname"));
	             customer.setLastName(rs.getString("lastname"));
	             customer.setUserName(rs.getString("username"));
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


	
	public void saveCAccount(Customer cust) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = Postgres.getConnection();
			String sql = "INSERT INTO \"Cancelled\" (id, firstname, lastname, username,accountnumber) VALUES (1,?,?,?,?)";

			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cust.getFirstName());
			stmt.setString(2, cust.getLastName());

			stmt.setString(3, cust.getUserName());
			stmt.setInt(4,cust.getA_number());
			
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
		// TODO Auto-generated method stub
		
	}

}
