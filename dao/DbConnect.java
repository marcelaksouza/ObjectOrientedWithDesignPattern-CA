package ObjectOrientedWithDesignPattern_CA.dao;

import java.sql.Connection;
//abstract Db Connect Factory class
public abstract class DbConnect {

	public abstract Connection getConnection();

	public abstract void connect();

	public abstract void disconnect();

}