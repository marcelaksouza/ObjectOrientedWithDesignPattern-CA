package ObjectOrientedWithDesignPattern_CA;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
		//View.mainMenu();	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runApp();

		
//		countryDAO.getOneCountryByCode("T7T");
		System.out.println(countryDAO.getOneCountryByCode("T7T"));
	
	//countryDAO.addCountry(new Country("T7T",Continent.europe,"test",1000F,"test"));
	
//	try {
//		ArrayList<Country> countryList = countryDAO.getAllCountries(); 
//		for(Country country : countryList) {
//			System.out.println(country);
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
	}
	
}

//Arrays.toString(list.toArray().toString)