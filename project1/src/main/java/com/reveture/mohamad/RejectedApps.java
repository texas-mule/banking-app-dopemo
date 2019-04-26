package com.reveture.mohamad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RejectedApps implements RejectedClassInterface {
	public List<Applications> getAllApplications() {
		List<Applications> apps = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = Postgres.getConnection();

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"RejectedApps\";" );
	         while ( rs.next() ) {
	             
	             Applications app= new Applications();
	             app.setId(rs.getInt("Id"));
	             app.setFirstname(rs.getString("firstname"));
	             app.setLastname(rs.getString("lastname"));
	             app.setUsername(rs.getString("username"));
	             app.setPassword(rs.getString("Password"));
	             app.setC_score(rs.getInt("creditscore"));
	             apps.add(app);
	             
	            
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

		return apps;
	}

	public void saveApplication(Applications app) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = Postgres.getConnection();
			String sql = "INSERT INTO \"RejectedApps\" (firstname, lastname, username, password, creditscore) VALUES (?,?,?,?,?)";

			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, app.getFirstname());
			stmt.setString(2, app.getLastname());

			stmt.setString(3, app.getUsername());
			stmt.setString(4, app.getPassword());
			stmt.setInt(5, app.getC_score());
			
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
			throw new Exception("Insert Customer failed: ");
		}

	}
	public void deleteApp(Applications app) {
		Connection connection=null;
		PreparedStatement pstmt = null;
		String sql="DELETE FROM \"RejectedApps\" WHERE \"Id\" = ?";
		int affectedrows = 0;
		 
        try {
        	connection = Postgres.getConnection();
        	pstmt = connection.prepareStatement(sql);
 
            pstmt.setInt(1, app.getId());
 
            affectedrows = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		
}
}