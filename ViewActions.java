package ObjectOrientedWithDesignPattern_CA;

import java.util.Scanner;

public class ViewActions {
	
	
	
	public ViewActions() {}
	
	public void mainMenuSwitch(){
        switch(Integer.parseInt(readUserInput())){
        case 1:{
        	
        }break;
        case 2:{
        	
        }break;
        case 3:{
           
        }break;
        case 4:{
        	
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
	
	public String readUserInput(){
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String input = sc.next();  // Read user input
     return input; 
	}
}
