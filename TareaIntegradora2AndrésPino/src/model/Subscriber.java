package model;

public class Subscriber {

	private String idSub;
	private String nameSub;
	private String status;
	private int age;
	private int hoursNum;
	private TypeSub typeSub;

	/**
	 * This is the constructor to add the information of the array Subscriber[]
	 * 
	 * @param idSub
	 * @param nameSub
	 * @param age      This is the user age
	 * @param hoursNum This is the user hours to consume
	 * @param typeSub  This is the enum that's in TypeSub class (NORMAL, GOLD,
	 *                 PLATINUM, DIAMOND)
	 * @param status   This is the user status
	 */
	public Subscriber(String idSub, String nameSub, int age, int hoursNum, TypeSub typeSub, String status) {
		this.idSub = idSub;
		this.nameSub = nameSub;
		this.age = age;
		this.hoursNum = hoursNum;
		this.typeSub = typeSub;
		this.status = status;
	}

	/**
	 * Constructor of idSub
	 * 
	 * @param idSub id of the subscriber
	 * 
	 */
	public void setIdSub(String idSub) {
		this.idSub = idSub;
	}

	/**
	 * Method to get IdSub
	 * 
	 * @return idSub
	 */
	public String getIdSub() {
		return idSub;
	}

	/**
	 * Constructor of nameSub
	 * 
	 * @param nameSub name of subscriber
	 * 
	 */
	public void setNameSub(String nameSub) {
		this.nameSub = nameSub;
	}

	/**
	 * Method to get nameSub
	 * 
	 * @return nameSub
	 */
	public String getNameSub() {
		return nameSub;
	}

	/**
	 * Constructor of age
	 * 
	 * @param age age of the user/subscriber
	 * 
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Method to get Age
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Constructor of hoursNum
	 * 
	 * @param hoursNum hoursNum the user is willing to use this app
	 * 
	 */
	public void setHoursNum(int hoursNum) {
		this.hoursNum = hoursNum;
	}

	/**
	 * Method to get HoursNum
	 * 
	 * @return hoursNum
	 */
	public int getHoursNum() {
		return hoursNum;
	}

	/**
	 * Constructor of typeSub
	 * 
	 * @param typeSub ENUM of TypeSub class
	 * 
	 */
	public void setTypeSub(TypeSub typeSub) {
		this.typeSub = typeSub;
	}

	/**
	 * Method to get TypeSub
	 * 
	 * @return typeSub
	 */
	public TypeSub getTypeSub() {
		return typeSub;
	}

	/**
	 * Constructor of status
	 * 
	 * @param status status entered by the used
	 * 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Method to get Status
	 * 
	 * @return Status
	 */
	public String getStatus() {
		return status;
	}
}