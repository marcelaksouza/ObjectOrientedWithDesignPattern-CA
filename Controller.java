package ObjectOrientedWithDesignPattern_CA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

//controller class
public class Controller {
	private static Client view = new Client();
	private static CountryDAO countryDAO = new CountryDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
	
	//start 
	public static void start() {
		view.mainMenu();
		mainMenuSwitch();
	}
	
	//main menu switch
	public static void mainMenuSwitch(){	
		switch(view.readUserInputInt()){
		case 1:{
			//call method to get all the entries in the DB
			printAllCountries();
			start();
		}break;
		case 2:{
			//call method to get entry by code
			printOneByCode(view.getByCodeForm());
			start();
		}break;
		case 3:{
			//call method to get entry by name
			printOneByName(view.getByNameForm());
			start();
		}break;
		case 4:{
			//call method to add a new entry
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
			//default behavior 
			System.out.println("Please type a valid option");
			start();
		}
	}
	// print all countries
	// from the countryDAO get all entries from the db and put into a array list
	// Then itenerate though it and print the results
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

	//print one entry by code
	//the method accept a string as a parameter and passed it to the contryDAO
	public static void printOneByCode(String code) {
		System.out.println(countryDAO.getOneCountryByCode(code));
	}
	
	//print one entry by name
	//the method accept a string as a parameter and passed it to the contryDAO
	//the first entry that matches the string is the one that will be returned 
	public static void printOneByName(String name) {
		System.out.println(countryDAO.getOneCountryByName(name));
	}
	
	//add country function
	//accepts a hashMap as a parameter and from its values create a new country 
	//and add it to the database
	public static void addCountry(HashMap<String, String> countrymap) {
	
		countryDAO.addCountry(new Country(countrymap.get("code"), 
				   Continent.getValueOf(countrymap.get("continent")),
				   countrymap.get("name"),
				   Float.valueOf(countrymap.get("surfaceArea")),
				   countrymap.get("headOfState")));
		printOneByCode(countrymap.get("code"));
	}
}

