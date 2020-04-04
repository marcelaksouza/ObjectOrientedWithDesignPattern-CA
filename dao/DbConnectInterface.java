package ObjectOrientedWithDesignPattern_CA.dao;

import java.sql.Connection;

public interface DbConnectInterface {

	//@Override get connection from the constructor
	Connection getConnection();

	//@Override stabelish connection
	void connect();

	//@Override disconnect
	void disconnect();

}