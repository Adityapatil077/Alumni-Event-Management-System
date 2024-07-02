package org.alumnievent.config;

import java.sql.*;

public class DBConfig {

	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;

	public DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AlumniEventManagement","root","Aditya@2001");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smprowor_alumnieventmanagement",
//					"smprowor_aditya", "Kc,dw&eBWEt]");
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
	}
}
