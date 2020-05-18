package com.d3ti.pboLanjut20.jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.*; 

public class DBBiodata implements ActionListener{
	Statement st;
	ResultSet rs;
	Connection con;
	public DBBiodata(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooplan?user=root&password=");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public Vector data() {
		try {
			st = (Statement) con.createStatement();
			rs = (ResultSet) ((java.sql.Statement) st).executeQuery("SELECT * FROM datadiri");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Vector dBdata = new Vector(1);

		try {
			while(rs.next()){
				Vector rows = new Vector();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				rows.add(rs.getString(5));
				rows.add(rs.getString(6));
				rows.add(rs.getString(7));
				dBdata.addElement(rows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dBdata;
	}
	public void insertBiodata(String nim, String nama, String jk, String tmp_lahir, String tgl_lahir, String alamat) {
		try {
			st = (Statement) con.createStatement();
			st.executeUpdate("INSERT INTO ooplan VALUES("+nim+","+nama+","+jk+","+tmp_lahir+","+tgl_lahir+","+alamat+")");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	JTextField tf1,tf2,tf3;  
    JButton button;  
    public void TextFieldExample(){  
        JFrame f= new JFrame();  
        tf1=new JTextField();  
        tf1.setBounds(50,50,150,20);  
        tf2=new JTextField();  
        tf2.setBounds(50,100,150,20);  
        tf3=new JTextField();  
        tf3.setBounds(50,150,150,20); 
        button=new JButton("Input");  
        button.setBounds(50,200,50,50);
        button.addActionListener(this); 
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(button);
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  

    }
    
    public static void main(String[] args) {
    	DBBiodata bio = new DBBiodata();
    	bio.TextFieldExample();
    }

		
	

}
