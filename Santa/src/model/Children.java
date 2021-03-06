package model;

/**
 * Children class
 */
public class Children implements Comparable<Children> {

	private String name;
	private String lastName;
	private int age;
	private String address;
	private String city;
	private String country;
	private String christmasGift;
	private int typeKid;

	/**
	 * Children's contructor
	 * 
	 * @param name
	 * @param lastName
	 * @param age
	 * @param address
	 * @param city
	 * @param country
	 * @param christmasGift
	 */
	public Children(String name, String lastName, int age, String country, String city, String address,
			String christmasGift, int typeKid) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.city = city;
		this.country = country;
		this.christmasGift = christmasGift;
		this.typeKid = typeKid;

	}

	/**
	 * 
	 * @return name ...
	 */
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

	/**
	 * 
	 * @return age ...
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 
	 * @return country ...
	 */
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

	/**
	 * 
	 * @return city ...
	 */
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

	/**
	 * 
	 * @return address ...
	 */
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

	/**
	 * 
	 * @return typeKid getTypeKid
	 */
	public int getTypeKid() {
		return typeKid;
	}

	/**
	 * 
	 * @param typeKid
	 */
	public void setTypeKid(int typeKid) {
		this.typeKid = typeKid;
	}

	@Override
	public String toString() {
		return "\nName: " + name + "\nLast name: " + lastName + "\nAge: " + age + "\nCountry: " + country + "\nCity: "
				+ city + "\nAddress: " + address + "\nchristmasGift: " + christmasGift + "\nType kid: " + typeKid
				+ "\n";
	}

	@Override
	public int compareTo(Children o) {
		int msg = getAge() - o.getAge();

		if (msg > 0) {
			return 1;
		} else if (msg < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}