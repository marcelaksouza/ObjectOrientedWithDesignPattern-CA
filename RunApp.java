package ObjectOrientedWithDesignPattern_CA;

public class RunApp {
	public static void runApp() {
		DB db = DB.getInstance();
		View view = new View(db);
		Controller controller = new Controller(db, view);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runApp();
	}

}
