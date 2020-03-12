package ObjectOrientedWithDesignPattern_CA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Java_CA_5_semester.Person;
import Java_CA_5_semester.Priority;

public class CountryDAO {
	
	
	public void addCountry(Country country) {
		
        try {
		DataBase.getInstance().connect();
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
	
//	public ArrayList<Country> getAllCountries() {
//		try {
//		Connection conn = DataBase.getInstance().getConnection();
//		Statement stmt=	conn.createStatement();
//				
//		String query = "SELECT * FROM country";
//	    ResultSet rs = stmt.executeQuery(query);
//	    ArrayList<Country> countryList = new ArrayList<>();
//	    while (rs.next()) {
//	    	Country crountry = new Country(
//	    			Continent.valueOf(rs.getString("Code")), 
//	    							   rs.getString("Name"), 
//	    							   rs.getString("Continent"), 
//	    							   rs.getFloat("SurfaceArea"), 
//	    							   rs.getString("HeadOfState")
//	    							   );
//	    	countryList.add(crountry);
//	    }
//		    stmt.close();
//		    conn.close();
//		    return countryList;
//	    } catch (Exception e) {
//	        System.out.print(e);
//	    }
//		return null; 
//	  }
//	}
	
	public Country getOneCountryByCode(String code) {
		return null;
	}
	
	public Country getOneCountryByName(String name) {
		return null;
	}
	
	
}
