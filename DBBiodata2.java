package com.d3ti.pboLanjut20.jdbc;
import java.sql.*;

public class DBBiodata2 {
	public static void main(String[] args) {
		Connection con = null;
		String url 		= "jdbc:mysql://localhost:3306/ooplan";
		String user 	= "root";
		String password	= "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
			
			if(!con.isClosed())
				System.out.println("Succesfully connected to mysql server..");
	
		}catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}finally {
			try {
				if(con != null)
					con.close();
			}catch(SQLException e){
				
			}
		}
		
		

	}
	
	
}