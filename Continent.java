package ObjectOrientedWithDesignPattern_CA;

public enum Continent {
	south_America("South America", "21U"),
	north_America("North America", "6NE"),
	oceania("Oceania", "9K8"),
	europe("Europe", "3AL"),
	africa("Africa" , "AFD"),
	asia("Asia", "24E"),
	antarctica("Antarctica","1EM");
	
	private final String continent;
	private final String code;
	
	private Continent(String continent, String code) {
		this.continent = continent;
		this.code = code;
	}
	
	public String getContinent() {
		return continent;
	}
	public String getCode() {
		return code;
	}
	
}

//we can use Continent.valueOf("Country1").continent();