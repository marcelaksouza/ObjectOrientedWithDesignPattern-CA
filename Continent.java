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
	
	
//	public static Continent getValueOf(String value) {
//		
//		if(value.equals("Europe")) {
//			return europe;
//		}
//		
//		return null;
//	}
	
	public static Continent getValueOf(String value) {
      
		for (Continent continetEnum : Continent.values()) {
            if (continetEnum.continent.equalsIgnoreCase(value)) {
                return continetEnum;
            }
        }
        return null;
    }
	
	
}

//we can use Continent.valueOf("Country1").continent();