package ObjectOrientedWithDesignPattern_CA;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class CountryDAO {

	public abstract void addCountry(Country country);

	public abstract ArrayList<Country> getAllCountries() throws SQLException;

	public abstract Country getOneCountryByCode(String code);

	public abstract Country getOneCountryByName(String name);

}