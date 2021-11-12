package model;
public class Children implements Comparable<Children>{

	private String name;
	private String lastName;
	private int edad;
	private String address;
	private String city;
	private String country;
	private String christmasGift;
	private String typeKid;

	/**
	 * 
	 * @param name
	 * @param lastName
	 * @param edad
	 * @param address
	 * @param city
	 * @param country
	 * @param christmasGift
	 */
	public Children(String name, String lastName, int edad, String address, String city, String country, String christmasGift, String typeKid) {
		this.name = name;
		this.lastName = lastName;
		this.edad = edad;
		this.address = address;
		this.city = city;
		this.country = country;
		this.christmasGift = christmasGift;
		this.typeKid = typeKid;

	}

	public String getTypeKid(){
		return typeKid;
	}
	
	public void setTypeKid(String typeKid){

	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public String getChristmasGift() {
		return christmasGift;
	}

	/**
	 * 
	 * @param christmasGift
	 */
	public void setChristmasGift(String christmasGift) {
		this.christmasGift = christmasGift;
	}

	@Override
    public int compareTo(Children o) {
		if(edad<o.edad){
		}
        return this.name.compareTo(o.name);
	}
}