package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
//abstract Db Connect Factory class
public abstract class DbConnectFactory {

	public abstract Connection getConnection();

	public abstract void connect();

	public abstract void disconnect();

}