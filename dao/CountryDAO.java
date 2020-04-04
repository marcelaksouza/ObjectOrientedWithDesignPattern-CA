package ObjectOrientedWithDesignPattern_CA.dao;

import java.util.ArrayList;
import ObjectOrientedWithDesignPattern_CA.view.*;
import ObjectOrientedWithDesignPattern_CA.controller.*;
import ObjectOrientedWithDesignPattern_CA.dao.*;
import ObjectOrientedWithDesignPattern_CA.entity.*;
import ObjectOrientedWithDesignPattern_CA.validation.*;

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