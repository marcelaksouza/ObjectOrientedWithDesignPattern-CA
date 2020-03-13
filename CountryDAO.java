package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Java_CA_5_semester.Person;
import Java_CA_5_semester.Priority;



public class CountryDAO {
//	Connection conn = DataBase.getInstance().getConnection();
	
	public CountryDAO() {
		//DataBase.getInstance().connect();
		
		
	}
	public void addCountry(Country country) {
        try {
        	Connection conn = DataBase.getInstance().getConnection();
			String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState)" + " VALUES (?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, country.getCode());
			preparedStmt.setString (2, country.getName());
			preparedStmt.setString (3, country.getContinent());
			preparedStmt.setFloat (4, country.getSurfaceArea());
			preparedStmt.setString (5, country.getHeadOfState());
			preparedStmt.execute();
			preparedStmt.close();
			System.out.print("inserido no database com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("addCountry"+e);
		}
	}
	
	public ArrayList<Country> getAllCountries() throws SQLException{
		DataBase.getInstance().connect();
		Connection conn = DataBase.getInstance().getConnection();
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
	    	Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);
	    	countryList.add(crountry);
	    	
		  }
	   // System.out.print("get All Countries working ");
	    stmt.close();
	    conn.close();
		return countryList;
	}
	
	public Country getOneCountryByCode(String code) {
		
		try {
		DataBase.getInstance().connect();
		Connection conn = DataBase.getInstance().getConnection();
		Statement stmt=	conn.createStatement();
		String query = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country WHERE Code =\"" + code +"\";";
		//execute second query and save the result set into the variable rs
		ResultSet rs = stmt.executeQuery(query);
	    
	    while (rs.next()) {
			Continent continent = Continent.getValueOf(rs.getString("Continent"));
			String name = rs.getString("Name");	    				
			Float SurfaceArea = rs.getFloat("SurfaceArea");
			String HeadOfState = rs.getString("HeadOfState");
			Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);

	    	//return map
	        return crountry; 
	    }
	    //closing statement and connection 
	    stmt.close();
	    conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}
	
	public Country getOneCountryByName(String name) {

		try {
		DataBase.getInstance().connect();
		Connection conn = DataBase.getInstance().getConnection();
		Statement stmt=	conn.createStatement();
		String query = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country where Name =\"" + name +"\";";
		//execute second query and save the result set into the variable rs
		ResultSet rs = stmt.executeQuery(query);
	    
	    while (rs.next()) {
	    	String code = rs.getString("Name");	  
			Continent continent = Continent.getValueOf(rs.getString("Continent"));			
			Float SurfaceArea = rs.getFloat("SurfaceArea");
			String HeadOfState = rs.getString("HeadOfState");
			Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);

	    	//return map
	        return crountry; 
	    }
	    //closing statement and connection 
	    stmt.close();
	    conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}
	
	
	
}
