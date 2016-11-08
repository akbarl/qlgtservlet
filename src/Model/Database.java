package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/QLGT";
	
	static final String USER = "root";
	static final String PASS = "user";
	
	private Connection conn = null;
	
	public Database() throws Exception {
		Class.forName(JDBC_DRIVER);
		try
		{
			setConn(DriverManager.getConnection(DB_URL,USER,PASS));	
		}
		catch (SQLException e) {
			 throw new Exception(e.getMessage() + "Connect failed to database .... ");
		 }
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
