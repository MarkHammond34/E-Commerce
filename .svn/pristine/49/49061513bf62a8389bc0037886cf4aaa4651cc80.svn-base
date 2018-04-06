package edu.ben.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private String USER = "root";
	private String PASS = "password";
	private String dbName;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/" + "?autoReconnect=true&useSSL=false";
	private static Connection conn = null;

	public DBConnect() {

		this.dbName = "headphonesdb";
		connect();
	}

	public DBConnect(String dbName) {

		this.dbName = dbName;
		connect();
	}

	public boolean connect() {

		try {

			Class.forName(JDBC_DRIVER);

			// Creates the connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public String getDBName() {
		return dbName;
	}
}