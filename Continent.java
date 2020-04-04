package ObjectOrientedWithDesignPattern_CA;

//continent enum

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
	
	//method that will check if the string passed belongs to the enum list
	public static Continent getValueOf(String value) {
		for (Continent continetEnum : Continent.values()) {
            if (continetEnum.continent.equalsIgnoreCase(value)) {
                return continetEnum;
            }
        }
        return null;
    }
	@Override
    public String toString(){
        return continent;
    }

}
