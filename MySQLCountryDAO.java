package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Java_CA_5_semester.Person;
import Java_CA_5_semester.Priority;



public class MySQLCountryDAO extends CountryDAO {
	
	
	public MySQLCountryDAO() {
		
	}
	
	@Override
	public void addCountry(Country country) {
		dbConnectMySQL.getInstance().connect();
		Connection conn = dbConnectMySQL.getInstance().getConnection();
        try {
        	
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
	
	@Override
	public ArrayList<Country> getAllCountries() throws SQLException{
		dbConnectMySQL.getInstance().connect();
		Connection conn = dbConnectMySQL.getInstance().getConnection();
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
		return countryList;
	}
	
	@Override
	public Country getOneCountryByCode(String code) {
		dbConnectMySQL.getInstance().connect();
		Connection conn = dbConnectMySQL.getInstance().getConnection();
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
			Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);

	    	//return map
	        return crountry; 
	    }
	    //closing statement and connection 
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}
	
	@Override
	public Country getOneCountryByName(String name) {
		
		dbConnectMySQL.getInstance().connect();
		Connection conn = dbConnectMySQL.getInstance().getConnection();
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
			Country crountry = new Country(code, continent , name ,SurfaceArea, HeadOfState);

	    	//return map
	        return crountry; 
	    }
	    //closing statement and connection 
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}
}
