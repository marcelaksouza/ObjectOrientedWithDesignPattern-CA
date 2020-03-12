package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



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
		return null;
	}
	
	public Country getOneCountryByName(String name) {
		return null;
	}
	
	
	
}
