package ObjectOrientedWithDesignPattern_CA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ObjectOrientedWithDesignPattern_CA.entity.*;

// Country DAO
// Class that will interact with the db trough some of the CRUD functions
public class MySqlCountryDAO implements CountryDAO  {
	private Connection conn;
	
	//connect to the db
	public MySqlCountryDAO() {
		DbConnectMySql.getInstance().connect();
		conn = DbConnectMySql.getInstance().getConnection();
	}
	
	//add country 
	//method accept Country as parameter and access it properties to add the new country to the db
	@Override
	public void addCountry(Country country) {
		
		Connection conn = DbConnectMySql.getInstance().getConnection();
		try {
			String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState)" + " VALUES (?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, country.getCode());
			preparedStmt.setString (2, country.getName());
			preparedStmt.setString (3, country.getContinent().toString());
			preparedStmt.setFloat (4, country.getSurfaceArea());
			preparedStmt.setString (5, country.getHeadOfState());
			//execute statement
			preparedStmt.execute();
			//close statement
			preparedStmt.close();
			System.out.println("inserido no database com sucesso ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("addCountry"+e);
		}
	}
	
	//method get all entries of the db tranform them into a object country 
	//then add them to a arraylist
	@Override
	public ArrayList<Country> getAllCountries() {
		try {
			ArrayList<Country> countryList = new ArrayList<Country>();
			String query = "SELECT * FROM country";
			Statement stmt=	conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				String code = rs.getString("Code");
				Continent continent = Continent.getValueOf(rs.getString("Continent"));
				String name = rs.getString("Name");	    				
				Float SurfaceArea = rs.getFloat("SurfaceArea");
				String HeadOfState = rs.getString("HeadOfState");
				//create the object Country
				Country.BuilderCountry countryBuilder = new Country.BuilderCountry(code, continent , name ,SurfaceArea, HeadOfState);
				Country country = countryBuilder.build();
				//add to the array list
				countryList.add(country);
				
			}
			stmt.close();
			return countryList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//closing statement 
		return null;
	}

	//get one entry and create a object country
	@Override
	public Country getOneCountryByCode(String code) {
		try {
			Statement stmt=	conn.createStatement();
			String query = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country WHERE Code =\"" + code +"\";";
			//execute second query and save the result set into the variable rs
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Continent continent = Continent.getValueOf(rs.getString("Continent"));
				String name = rs.getString("Name");	    				
				Float SurfaceArea = rs.getFloat("SurfaceArea");
				String HeadOfState = rs.getString("HeadOfState");
				//create the object
				Country.BuilderCountry countryBuilder = new Country.BuilderCountry(code, continent , name ,SurfaceArea, HeadOfState);
				Country country = countryBuilder.build();
				//add to the array list
				
				//return map
				return country; 
			}
			//closing statement 
			stmt.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}

	//get one entry and create a object country
	@Override
	public ArrayList<Country> getCountryByName(String value) {
		try {
			ArrayList<Country> countryList = new ArrayList<Country>();
			String query = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country WHERE Name LIKE \'%" + value +"%\';";
			
			Statement stmt=	conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				String code = rs.getString("Code");
				Continent continent = Continent.getValueOf(rs.getString("Continent"));
				String name = rs.getString("Name");	    				
				Float SurfaceArea = rs.getFloat("SurfaceArea");
				String HeadOfState = rs.getString("HeadOfState");
				//create the object Country
				Country.BuilderCountry countryBuilder = new Country.BuilderCountry(code, continent , name ,SurfaceArea, HeadOfState);
				Country country = countryBuilder.build();
				//add to the array list
				countryList.add(country);
			}
			stmt.close();
			return countryList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//closing statement 
		return null;
	}
}
