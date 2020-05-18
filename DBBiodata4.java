//https://www.youtube.com/watch?v=kxIg0OUo4eI
package com.d3ti.pboLanjut20.jdbc;

import java.sql.*;

public class DBBiodata4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url 	="jdbc:mysql://localhost:3306/ooplan";
		String user	="root";
		String password	="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);

			Statement stt = con.createStatement();
			
			//Select DB			
			stt.execute("USE ooplan");
			ResultSet res = stt.executeQuery("SELECT * FROM datadiri");
			while(res.next()) {
				System.out.println(res.getString("nama")+" "+res.getString("alamat"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
