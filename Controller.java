package ObjectOrientedWithDesignPattern_CA;

import java.sql.SQLException;
import java.util.ArrayList;


public class Controller {
	private static View view = new View();
	private static MySQLCountryDAO mySQLcountryDAO = new MySQLCountryDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
	
	public static void start() {
		view.mainMenu();
		mainMenuSwitch();
	}
	
	public static void mainMenuSwitch(){
		switch(Integer.parseInt(view.readUserInput())){
		case 1:{
			printAllCountries();
			start();
		}break;
		case 2:{
			printOneByCode(view.getByCodeForm());
			start();
		}break;
		case 3:{
			//System.out.println(view.getByNameForm());
			printOneByName("test");
			start();
		}break;
		case 4:{
			view.printMap(view.addCountryForm()); 
			start();
			//falta conecetar com db
		}break; 
		case 5:{
			//exit
			System.out.println("Good Bye");
			System.exit(0);
		}break; 
		default:
			System.out.println("Please type a valid option");
		}
	}
	
	public static void printAllCountries() {
		try {
			ArrayList<Country> countryList = mySQLcountryDAO.getAllCountries();
			for (Country country: countryList) {
				System.out.println(country);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printOneByCode(String code) {
		System.out.println(mySQLcountryDAO.getOneCountryByCode(code));
	}
	
	public static void printOneByName(String name) {
		System.out.println(mySQLcountryDAO.getOneCountryByName(name));
	}
}

