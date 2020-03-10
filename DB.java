package ObjectOrientedWithDesignPattern_CA;

public class DB {
	private static DB instance = new DB();	
	
	 private DB() {
		
	}

	public static DB getInstance() {
		return instance;
	}

	public static void setInstance(DB instance) {
		DB.instance = instance;
	}
}
