package ObjectOrientedWithDesignPattern_CA;

import java.util.Scanner;
import java.util.HashMap;

//this class will deal with all client interaction
public class Client {
	//validator class
	Validator validator = new Validator();
	
	public Client() {
	}
	
	//main menu 
	public void mainMenu() {
		System.out.println("1. List all countries in the database");
		System.out.println("2. Find a country by country code");
		System.out.println("3. Find a country by name");
		System.out.println("4. Save a new country in the database");
		System.out.println("5. exit");
	}
	
	//add country form it returns a map of the inputs
	public HashMap<String, String> addCountryForm() {
		HashMap<String, String> countryMap = new HashMap<String, String>();
		//enter code
		System.out.println("Enter the code");
		String code = readUserInput();
		countryMap.put("code", code);

		//enter name
		System.out.println("Enter the name");
		String name = readUserInputString();
		countryMap.put("name", name);

		//enter continent if continent is not one of the options in the enum repeat
		System.out.println("Enter a continent from the list below");
		continentList();
		String continent = readUserInputString();
		while (!validator.isContinent(continent)) {
			System.out.println("You type "+continent);
			System.out.println("Please enter a valid option");
			continentList();
			continent = readUserInputString();
		}

		countryMap.put("continent", continent);
		//Enter headOfState
		System.out.println("Enter head of state");
		String headOfState = readUserInputString();
		countryMap.put("headOfstate", headOfState);
		//Enter surface area
		System.out.println("Enter surface area");
		String surfaceArea = readUserInput();
		countryMap.put("surfaceArea", surfaceArea);

		return countryMap;
	}
	//continent list it iterates through continent list and display them
	public void continentList() {
		for( Continent continent : Continent.values()) {
			System.out.println(continent);
		}
	}
	
	//read user input
	public String readUserInputString(){
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String input = sc.next();  // Read user input
		
		if(validator.isString(input)) {
			return input; 
		}
		return null;
	}
	
	//read user input it must be a int added validation
	public int readUserInputInt(){
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String input = sc.next();  // Read user input
		
		if(validator.isNumber(input)) {
			return Integer.parseInt(input); 
		}
		return -1;
	}
	
	//read user input it must be a String added validation
	public String readUserInput(){
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String input = sc.next();  // Read user input
		return input;
	}
	
	//print the map used mostly to debug
	public void printMap(HashMap<String, String> country) {
		for (String name: country.keySet()){
			String key = name.toString();
			String value = country.get(name).toString();  
			System.out.println(key + " " + value);  
		} 
	}

	//get by code form
	public String getByCodeForm() {
		System.out.println("Enter the code");
		String code = readUserInput();
		return code;
	}
	
	//get by name form
	public String getByNameForm() {
		System.out.println("Enter the name");
		String name = readUserInputString();
		return name;
	}
	
	
}
