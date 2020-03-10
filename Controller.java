package ObjectOrientedWithDesignPattern_CA;

public class Controller {
	 private DB db;
	 private View view;
	
	 public Controller(DB db, View view) {
			this.db = db;
			this.view = view;
	}
}
