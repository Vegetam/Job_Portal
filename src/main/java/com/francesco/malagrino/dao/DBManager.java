package com.francesco.malagrino.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	Connection connection = null;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Find the class comm.mysql.jdbc.Driver -
		// if the class not found then it throws error
		// ClassNotFoundException
		if (connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/registration?useTimezone=true&serverTimezone=UTC", "root", "");
			// here registration is a database name, root is username and password is
			// empty by default
		}
		return connection;
	}
}
