package com.banque.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConfigConnection {
	private static ConfigConnection instance;

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/banque", "root", "");
		} catch (Exception e) {
			System.out.println("Erreur " + e.getMessage());
		}
		return connection;
	}
	
	public static ConfigConnection getInstance() {
		if(instance == null) {
			instance = new ConfigConnection();
		}
		return instance;
	}

}