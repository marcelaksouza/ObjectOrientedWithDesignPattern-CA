package ObjectOrientedWithDesignPattern_CA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class Controller {
	private static Client view = new Client();
	private static CountryDAO countryDAO = new CountryDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
	
	public static void start() {
		view.mainMenu();
		mainMenuSwitch();
	}
	
	public static void mainMenuSwitch(){	
		switch(view.readUserInputInt()){
		case 1:{
			printAllCountries();
			start();
		}break;
		case 2:{
			printOneByCode(view.getByCodeForm());
			start();
		}break;
		case 3:{
			printOneByName(view.getByNameForm());
			start();
		}break;
		case 4:{
			addCountry(view.addCountryForm());
			start();
		}break; 
		case 5:{
			//exit
			DbConnectMySQL.getInstance().disconnect();;
			System.out.println("Good Bye");
			System.exit(0);
		}break; 
		default:
			System.out.println("Please type a valid option");
			start();
		}
	}
	
	public static void printAllCountries() {
		try {
			ArrayList<Country> countryList = countryDAO.getAllCountries();
			for (Country country: countryList) {
				System.out.println(country);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printOneByCode(String code) {
		System.out.println(countryDAO.getOneCountryByCode(code));
	}
	
	public static void printOneByName(String name) {
		
		System.out.println(countryDAO.getOneCountryByName(name));
	}
	
	
	public static void addCountry(HashMap<String, String> countrymap) {
		
		Country country = new Country(countrymap.get("code"), 
				   Continent.getValueOf(countrymap.get("continent")),
				   countrymap.get("name"),
				   Float.valueOf(countrymap.get("surfaceArea")),
				   countrymap.get("headOfState"));
		countryDAO.addCountry(country);
		printOneByCode(countrymap.get("code"));
	}
}

