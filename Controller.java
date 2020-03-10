package ObjectOrientedWithDesignPattern_CA;

public class Controller {
	 private DataBase db;
	 private View view;
	
	 public Controller(DataBase db, View view) {
			this.db = db;
			this.view = view;
	}
}
