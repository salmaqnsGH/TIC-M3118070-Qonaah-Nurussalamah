package com.d3ti.pboLanjut20.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.*;

public class DBBiodata5 {
	Connection con;
	Statement st;
	ResultSet rs;
	public DBBiodata5(){
			try { 
			String url ="jdbc:mysql://localhost:3306/ooplan";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            System.out.println("koneksi berhasil;");
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con =DriverManager.getConnection(url,user,pass);
				 st = con.createStatement();
			}catch (SQLException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
				System.err.println("koneksi gagal" +e.getMessage());
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public Vector data() {
		try {
			st = (Statement) con.createStatement();
			rs=(ResultSet)st.executeQuery("SELECT * FROM datadiri");
			 System.out.println("Table berhasil;");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vector dBdata = new Vector(1);
		
		try {
			while(rs.next())
			{
			Vector rows = new Vector();
			rows.add(rs.getString(1));
			rows.add(rs.getString(2));
			rows.add(rs.getString(3));
			rows.add(rs.getString(4));
			rows.add(rs.getString(5));
			rows.add(rs.getString(6));
			dBdata.addElement(rows);
			 System.out.println("Data berhasil;");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return dBdata;
	}
	
}

