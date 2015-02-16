package org.rusl.ethpaura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/ethpaura";
			String user = "root";
			String password = "admin1234";

			// Load the Connector/J driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establish connection to MySQL
			Connection conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
