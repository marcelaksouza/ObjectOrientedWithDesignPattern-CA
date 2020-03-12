package ObjectOrientedWithDesignPattern_CA;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
	 private DataBase db;
	 private View view;
	 private CountryDAO countryDAO = new CountryDAO();
	
	 public Controller(DataBase db, View view) {
			this.db = db;
			this.view = view;
	}
	
	public void addCountry(Country country) {
		try {
			countryDAO.addCountry(new Country("225",Continent.north_America, "Brasil", 10000F, "Brasilia"));
			
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}; 
	 
}
