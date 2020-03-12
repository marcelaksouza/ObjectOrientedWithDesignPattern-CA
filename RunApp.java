package ObjectOrientedWithDesignPattern_CA;

public class RunApp {
	
	DataBase db = DataBase.getInstance();
	View view = new View();
	Controller controller = new Controller(db, view);
	static CountryDAO countryDAO = new CountryDAO();
	public static void runApp() {
//		DataBase db = DataBase.getInstance();
//		View view = new View();
//		Controller controller = new Controller(db, view);
//		CountryDAO countryDAO = new CountryDAO();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runApp();
//		DataBase.getInstance().connect();
//		DataBase.getInstance().disconnect();;
		
	//View.mainMenu();	
	//precisa testar pra adicionar um country
		countryDAO.addCountry(new Country("T7T",Continent.europe,"test",1000F,"test"));
	}
	//Country(String code, Continent continent, String name, float surfaceArea, String headOfState)
}
