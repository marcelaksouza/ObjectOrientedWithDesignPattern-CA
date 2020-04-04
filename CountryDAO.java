package ObjectOrientedWithDesignPattern_CA;

import java.util.ArrayList;

public interface CountryDAO {

	//add country 
	//method accept Country as parameter and access it properties to add the new country to the db
	void addCountry(Country country);

	//method get all entries of the db tranform them into a object country 
	//then add them to a arraylist
	ArrayList<Country> getAllCountries();

	//get one entry and create a object country
	Country getOneCountryByCode(String code);

	//get one entry and create a object country
	ArrayList<Country> getCountryByName(String name);

}