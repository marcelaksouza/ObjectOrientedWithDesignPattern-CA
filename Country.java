package ObjectOrientedWithDesignPattern_CA;

public class Country {
	//should i change to char?
	private String continent;
	private String code;
	private String name;
	private String HeadOfState;
	private double surfaceArea;

	public Country(Continent continent, String name, double surfaceArea, String headOfState) {
		super();
		this.continent = continent.getContinent();
		this.code = continent.getCode();
		this.name = name;
		this.surfaceArea = surfaceArea;
		HeadOfState = headOfState;
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
		return HeadOfState;
	}

	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}
	
	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
}
