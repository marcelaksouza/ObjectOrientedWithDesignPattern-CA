package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// Country DAO
// Class that will interact with the db trough some of the CRUD functions
public class CountryDAO  {

	//connect to the db
	public CountryDAO() {
		DbConnectMySQL.getInstance().connect();
	}
	
	//add country 
	//method accept Country as parameter and access it properties to add the new country to the db
	public void addCountry(Country country) {
		
		Connection conn = DbConnectMySQL.getInstance().getConnection();
		try {
			String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState)" + " VALUES (?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, country.getCode());
			preparedStmt.setString (2, country.getName());
			preparedStmt.setString (3, country.getContinent());
			preparedStmt.setFloat (4, country.getSurfaceArea());
			preparedStmt.setString (5, country.getHeadOfState());
			//execute statement
			preparedStmt.execute();
			//close statement
			preparedStmt.close();
			System.out.print("inserido no database com sucesso ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("addCountry"+e);
		}
	}
	
	//method get all entries of the db tranform them into a object country 
	//then add them to a arraylist
	public ArrayList<Country> getAllCountries() throws SQLException{

		Connection conn = DbConnectMySQL.getInstance().getConnection();
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
			Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);
			//add to the array list
			countryList.add(crountry);
		}
		//closing statement 
		stmt.close();
		return countryList;
	}

	//get one entry and create a object country
	public Country getOneCountryByCode(String code) {

		Connection conn = DbConnectMySQL.getInstance().getConnection();
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
				Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);

				//return map
				return crountry; 
			}
			//closing statement 
			stmt.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}

	//get one entry and create a object country
	public Country getOneCountryByName(String name) {

		DbConnectMySQL.getInstance().connect();
		Connection conn = DbConnectMySQL.getInstance().getConnection();
		try {
			Statement stmt=	conn.createStatement();
			String query = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country WHERE Name =\"" + name +"\";";
			//execute second query and save the result set into the variable rs
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String code = rs.getString("Code");	 
				Continent continent = Continent.getValueOf(rs.getString("Continent")); 				
				Float SurfaceArea = rs.getFloat("SurfaceArea");
				String HeadOfState = rs.getString("HeadOfState");
				//create the object
				Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);

				//return map
				return crountry; 
			}
			//closing statement 
			stmt.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}
}
