package ObjectOrientedWithDesignPattern_CA.entity;

//country class

public class Country {
	//Country variables
	private Continent continent;
	private String code;
	private String name;
	private String headOfState;
	private float surfaceArea;

	/*the constructor of Country is the builderCountry because is the builderCountry who passed all the 
	* parameters to build Country
	*/
	public Country(BuilderCountry builder) {
		super();
		this.continent = builder.continent;
		this.code = builder.code;
		this.name = builder.name;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
	}

	//getters and setters
	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
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
		this.headOfState = headOfState;
	}
	
	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
	@Override
	//to string method
	public String toString() {
	        return "Code: " + this.code + "\nName: " + this.name + "\nContinent: " + this.continent + "\nHead Of State: " + this.headOfState + "\nSurface Area: " + this.surfaceArea + "\n";
	 }
	/*inner class BuilderCountry it has the same parameters as Country and it has the job to pass
	 * this parameters to Country
	 * */
	public static class BuilderCountry{
		
		private Continent continent;
		private String code;
		private String name;
		private String headOfState;
		private float surfaceArea;
		
		public BuilderCountry(String code, Continent continent, String name, float surfaceArea, String headOfState) {
			this.continent = continent;
			this.code = code;
			this.name = name;
			this.surfaceArea = surfaceArea;
			this.headOfState = headOfState;
		}
		
		/*this function returns a instance of country and it 
		 * is responsible to initiate the new Country class using the 
		 * the parameters passed by the builder
		 */
		public Country build() {
			return new Country(this);
		}
	}
	
	
}
