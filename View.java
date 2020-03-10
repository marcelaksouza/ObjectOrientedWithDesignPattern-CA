package ObjectOrientedWithDesignPattern_CA;

import java.util.Scanner;

public class View {
	private DataBase db;

	public View(DataBase db) {
		this.db = db;
	}
	
	public static void mainMenu() {
		System.out.println("1. List all countries in the database");
		System.out.println("2. Find a country by country code");
		System.out.println("3. Find a country by name");
		System.out.println("4. Save a new country in the database");
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
        	
        }break; 
        default:
            System.out.println("Please type a valid option");
            mainMenu();
        }
	}
	public static String readUserInput(){
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String input = sc.next();  // Read user input
     return input; 
	}
}
