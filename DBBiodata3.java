package com.d3ti.pboLanjut20.jdbc;

import java.sql.*;

public class DBBiodata3 {

	public static void main(String[] args) throws Exception {
	    Connection conn = null;
	    try {
	        String userName = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost:3306/ooplan";
	        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        conn = DriverManager.getConnection(url, userName, password);
	        System.out.println("Database connection established");
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	                System.out.println("Database connection terminated");
	            } catch (Exception e) { /* ignore close errors */ }
	        }
	    }
	}

}
