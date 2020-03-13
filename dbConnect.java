package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;

public abstract class dbConnect {

	public abstract Connection getConnection();

	public abstract void connect();

	public abstract void disconnect();

}