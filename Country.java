package ObjectOrientedWithDesignPattern_CA;

public class Country {
	//should i change to char?
	private String continent;
	private String code;
	private String name;
	private String headOfState;
	private float surfaceArea;

	public Country(String code, Continent continent, String name, float surfaceArea, String headOfState) {
		super();
		this.continent = continent.getContinent();
		this.code = code;
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		headOfState = headOfState;
	}
	
	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
}
