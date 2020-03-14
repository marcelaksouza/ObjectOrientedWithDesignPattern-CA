package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//db connect Mysql extends abstract Db Connect Factory class

public class DbConnectMySQL extends DbConnectFactory {
	
	//db is initiated only once though the life time of the program
	private static DbConnectFactory instance = new DbConnectMySQL("52.50.23.197", "3306", "world", "cctstudent", "Pass1234!");
	Connection conn;
	String host;
	String port;
	String dbName;
	String user;
	String password;
	
	//to make it more flexible I am passing this parameters to the constructor
	private DbConnectMySQL(String host, String port, String dbName,String user, String password) {
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.user = user;
		this.password = password;
	}

	@Override
	//@Override get connection from the constructor
	public Connection getConnection() {
		return conn;
	}
	
	//get the db instance created
	public static DbConnectFactory getInstance() {
		return instance;
	}

	//setter of the instance
	public static void setInstance(DbConnectFactory instance) {
		DbConnectMySQL.instance = instance;
	}
	
	@Override
	//@Override stabelish connection
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
	//@Override disconnect
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
