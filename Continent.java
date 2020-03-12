package ObjectOrientedWithDesignPattern_CA;

public enum Continent {
	south_America("South America"),
	north_America("North America"),
	oceania("Oceania"),
	europe("Europe"),
	africa("Africa"),
	asia("Asia"),
	antarctica("Antarctica");
	
	private final String continent;
	
	private Continent(String continent) {
		this.continent = continent;
	}
	
	public String getContinent() {
		return continent;
	}
	
}

//we can use Continent.valueOf("Country1").continent();