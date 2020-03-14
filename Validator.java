package ObjectOrientedWithDesignPattern_CA;
//validations class
public class Validator {
	
	
	public Validator() {
		
	}
	//validate if is only letters
    public boolean isString(String imput) {
		if((imput).matches("[a-zA-Z]+")) {
			return true;
		}
		else {
			System.out.println("Please enter only Letters");
			return false;
		}
    	
    }
    //validate if is only numbers
    public boolean isNumber(String imput) {
    	//System.out.println("isNumber");
		if(String.valueOf(imput).matches("^[0-9]+")) {
			return true;
		}
		else {
			System.out.println("Please enter only numbers");
			return false;
		}

    }
    //validate if is numbers and letters only
    public boolean isAlphanumeric(String imput) {
    	
		if(imput.matches("^[A-Z0-9]{3}")) {
			return true;
		}
		else {
			System.out.println("Only letters and number are allowed, limited to 3 digits only. Try again");
			return false;
		}
	}
	
    //if is in the continent list
	public boolean isContinent(String userInput) {
			for( Continent continent : Continent.values()) {
				if( userInput.equalsIgnoreCase( continent.getContinent()) ) {
					return true;
				}
			}
			return false;
		}
    }
    
    
    

