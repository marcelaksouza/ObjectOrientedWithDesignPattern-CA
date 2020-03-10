package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private static DataBase instance = new DataBase("52.50.23.197", "3306", "world", "cctstudent", "Pass1234!");
	Connection conn = null;
	Statement stmt = null;
	String host;
	String port;
	String dbName;
	String user;
	String password;
	
	private DataBase(String host, String port, String dbName,String user, String password) {
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.user = user;
		this.password = password;
	}

	public static DataBase getInstance() {
		return instance;
	}

	public static void setInstance(DataBase instance) {
		DataBase.instance = instance;
	}
	
	public void connect() {
		 try {
		        // Load the database driver
		        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		        String dbServer = "jdbc:mysql://"+host+":"+port+"/"+dbName;
		        
		        // Get a connection to the database
		        conn = DriverManager.getConnection(dbServer, user, password);
		        if (conn != null) {
	        }
	        // Get a statement from the connection
	        stmt = conn.createStatement();
	        System.out.println("Database connected");
	    } catch (SQLException se) {
	        System.out.println("SQL Exception:");

	        // Loop through the SQL Exceptions
	        while (se != null) {
	            System.out.println("State  : " + se.getSQLState());
	            System.out.println("Message: " + se.getMessage());
	            System.out.println("Error  : " + se.getErrorCode());
	            se = se.getNextException();
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    	}
		}
		
	
	public void disconnect() {
		try {
			stmt.close();
			conn.close();
			System.out.println("Database disconnected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
