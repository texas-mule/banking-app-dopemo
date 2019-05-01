package com.reveture.mohamad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.mohamad.project01.Admin;
import com.revature.mohamad.project01.Applications;
public class CustomerImp implements PostgreImp{
	public List<Applications> getAllApplications() {
		List<Applications> apps = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = Postgres.getConnection();

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"Apps\";" );
	         while ( rs.next() ) {
	             
	             Applications app= new Applications();
	             app.setId(rs.getInt("Id"));
	             app.setFirstname(rs.getString("firstname"));
	             app.setLastname(rs.getString("lastname"));
	             app.setUsername(rs.getString("username"));
	             app.setPassword(rs.getString("Password"));
	             app.setC_score(rs.getInt("creditscore"));
	             app.setApplied(rs.getBoolean("applied"));
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
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apps;
	}

	public void saveApplication(Applications app) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = Postgres.getConnection();
			String sql = "INSERT INTO \"Apps\" (firstname, lastname, username, password, creditscore, applied) VALUES (?,?,?,?,?,?)";

			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, app.getFirstname());
			stmt.setString(2, app.getLastname());

			stmt.setString(3, app.getUsername());
			stmt.setString(4, app.getPassword());
			stmt.setInt(5, app.getC_score());
			stmt.setBoolean(6, app.isApplied());
			
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
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void deleteApp(Applications app) {
		Connection connection=null;
		PreparedStatement pstmt = null;
		String sql="DELETE FROM \"Apps\" WHERE \"Id\" = ?";
		int affectedrows = 0;
		 
        try {
        	connection = Postgres.getConnection();
        	pstmt = connection.prepareStatement(sql);
 
            pstmt.setInt(1, app.getId());
            
 
            affectedrows = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void apply(Applications app) {
		
		Connection connection=null;
		PreparedStatement pstmt = null;
		String sql="UPDATE \"Apps\" SET applied = ? WHERE username = ?";
		int affectedrows = 0;
		app.setApplied(true);
		 
        try {
        	connection = Postgres.getConnection();
        	pstmt = connection.prepareStatement(sql);
        	pstmt.setBoolean(1,app.isApplied());
            pstmt.setString(2, app.getUsername());
 
            affectedrows = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		
        try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public List<Admin> getAllAdmins() {
		List<Admin> admins = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = Postgres.getConnection();

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"Admin\";" );
	         while ( rs.next() ) {
	             
	             Admin admin= new Admin();
	             admin.setId(rs.getInt("Id"));
	             
	            admin.setUserName(rs.getString("username"));
	             admin.setPassword(rs.getString("Password"));
	             
	             admins.add(admin);
	             
	            
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
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins;
	}


	



}
