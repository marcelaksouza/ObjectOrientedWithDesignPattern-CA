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
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runApp();
//		DataBase.getInstance().connect();
//		DataBase.getInstance().disconnect();;
		
	//View.mainMenu();	
	
	//countryDAO.addCountry(new Country("T7T",Continent.europe,"test",1000F,"test"));
	
	try {
		ArrayList<Country> countryList = countryDAO.getAllCountries();
		 Iterator<Country> iterator = countryList.iterator();
	      while(iterator.hasNext()) {
	         System.out.println(iterator.next());
	      } 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
}

//Arrays.toString(list.toArray().toString)