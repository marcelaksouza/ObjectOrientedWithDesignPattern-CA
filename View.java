package ObjectOrientedWithDesignPattern_CA;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;

public class View {
	
	

	
	public View() {
	}
	
	public static void mainMenu() {
		System.out.println("1. List all countries in the database");
		System.out.println("2. Find a country by country code");
		System.out.println("3. Find a country by name");
		System.out.println("4. Save a new country in the database");
		System.out.println("5. exit");
		mainMenuSwitch();
	}
	
	public static void mainMenuSwitch(){
        switch(Integer.parseInt(readUserInput())){
        case 1:{
        	
        }break;
        case 2:{
        	
        }break;
        case 3:{
           
        }break;
        case 4:{
        	addCountryForm();
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
	
	public static Country addCountryForm() {
		HashMap<String, String> country = new HashMap<String, String>();
		//enter code
		System.out.println("Enter the code");
		String code = readUserInput();
		country.put("code", code);
		
		//enter name
		System.out.println("Enter the name");
		String name = readUserInput();
		country.put("name", name);
		
		//enter continent
		System.out.println("Enter a continent from the list below");
		continentList();
		String continent = readUserInput();
		while (!isContinent(continent)) {
			System.out.println("You type "+continent);
			System.out.println("Please enter a valid option");
			continentList();
			continent = readUserInput();
		}
		
		country.put("continent", continent);
		//Enter headOfState
		System.out.println("Enter head of state");
		String headOfState = readUserInput();
		country.put("headOfstate", headOfState);
		//Enter surface area
		System.out.println("Enter surface area");
		String surfaceArea = readUserInput();
		country.put("surfacAarea", surfaceArea);
		printMap(country);
		
		return null;
	}
	
	public static boolean isContinent(String userInput) {
		for( Continent continent : Continent.values()) {
		    if( userInput.equalsIgnoreCase( continent.getContinent()) ) {
		        return true;
		    }
		}
		    // exit program here or throw some exception
		return false;
	}
	
	public static void continentList() {
		for( Continent continent : Continent.values()) {
			System.out.println(continent);
		}
	}
	
	public static String readUserInput(){
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String input = sc.next();  // Read user input
     return input; 
	}
	
	public static void printMap(HashMap<String, String> country) {
		for (String name: country.keySet()){
            String key = name.toString();
            String value = country.get(name).toString();  
            System.out.println(key + " " + value);  
} 
	}
}
