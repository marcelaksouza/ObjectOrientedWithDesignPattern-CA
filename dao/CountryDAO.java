package ObjectOrientedWithDesignPattern_CA.dao;

import java.util.ArrayList;
import ObjectOrientedWithDesignPattern_CA.entity.*;

public interface CountryDAO {

	//add country 
	//This method will add a new country entry in the database
	void addCountry(Country country);

	/*get All Countries method will get all entries of the db create a Country object and add 
	* them to a arraylist
	*/
	ArrayList<Country> getAllCountries();

	//Method accept a string and return the corresponding Country object from the db
	Country getOneCountryByCode(String code);

	/*get Country By Name method will get all entries of the db corresponding to the name value passed 
	* then create a Country object and add 
	* them to a arraylist
	*/
	ArrayList<Country> getCountryByName(String name);

}