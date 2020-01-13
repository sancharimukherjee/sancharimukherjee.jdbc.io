package com.cognizant.truyum.dao;

import java.io.BufferedInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.cognizant.truyum.dao.ConnectionHandler;

public class ConnectionHandler {

	static Connection getConnection() {
		// Read the property from property file -> connection.properties
		BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");
		Properties prop = new Properties();
		try {
			prop.load(bufferedInputStream);
		} catch (Exception e) {
			System.out.println("Unable to laod/find connection.properties file");
		}
		String driver = (String) prop.get("driver");
		//System.out.println("Driver Name" + driver);
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the mysql driver");
		}
		String user = (String) prop.get("user");
		String password = (String) prop.get("password");
		String url = (String) prop.get("connection-url");
		Connection connection = null;
		try {
			// A connection(session) with a specified database
			// Driver Manager class will attempt to load the driver class
			connection = DriverManager.getConnection(url, user, password);
			//System.out.println(connection);
		} catch (Exception e) {
			System.out.println("Unable to connect to database");
		}

		// System.out.println("connection Details-> "+user+"--"+password+"--"+url);
		return connection;
	}

}
