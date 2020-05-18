package com.d3ti.pboLanjut20.jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Tampil extends JFrame {

 /**
  * 
  */
 private static final long serialVersionUID = 1L;
 private JPanel contentPane;
 DBBiodata biodata;
 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
    	 Tampil frame = new  Tampil();
     frame.setVisible(true);
      System.out.println("frame berhasil;");
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 public  Tampil() {
  super("Biodata");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 450, 300);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  contentPane.setLayout(new BorderLayout(0, 0));
  setContentPane(contentPane);
  
  JScrollPane scrollPane = new JScrollPane();
  contentPane.add(scrollPane, BorderLayout.CENTER);
  biodata = new DBBiodata();
  Vector<String> columnNames = new Vector<String>();
  columnNames.addElement("NIM");
  columnNames.addElement("NAMA");
  columnNames.addElement("JENIS KELAMIN");
  columnNames.addElement("TEMPAT LAHIR");
  columnNames.addElement("TANGGAL LAHIR");
  columnNames.addElement("ALAMAT");
  JTable table = new JTable(biodata.data(), columnNames);
  DefaultTableModel dtm=new DefaultTableModel(biodata.data(),columnNames);
  table.setModel(dtm);
  scrollPane.setColumnHeaderView(table);

 }

}