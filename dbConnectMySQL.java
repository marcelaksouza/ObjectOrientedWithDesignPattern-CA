package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnectMySQL extends DbConnectFactory {
	private static DbConnectFactory instance = new DbConnectMySQL("52.50.23.197", "3306", "world", "cctstudent", "Pass1234!");
	Connection conn;
	String host;
	String port;
	String dbName;
	String user;
	String password;
	
	private DbConnectMySQL(String host, String port, String dbName,String user, String password) {
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.user = user;
		this.password = password;
	}

	@Override
	public Connection getConnection() {
		return conn;
	}
	
	public static DbConnectFactory getInstance() {
		return instance;
	}

	public static void setInstance(DbConnectFactory instance) {
		DbConnectMySQL.instance = instance;
	}
	
	@Override
	public void connect()  {
		if (conn != null) {
			return;
		} 
		try {
		        // Load the database driver
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        String dbServer = "jdbc:mysql://"+host+":"+port+"/"+dbName;
		        
		        // Get a connection to the database
		        conn = DriverManager.getConnection(dbServer, user, password);
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
	        System.out.println("connection error"+e);
	    	}
		}
		
	@Override
	public void disconnect() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("Database disconnected");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		}
		conn = null;	
	}
}
