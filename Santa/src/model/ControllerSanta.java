package model;
import java.util.*;

public class ControllerSanta {

	private static ArrayList<Children> goodKids;
	private static ArrayList<Children> badKids;

	public ControllerSanta(){
		goodKids = new ArrayList<Children>();
		badKids = new ArrayList<Children>();
	}
	/**
	 * 
	 * @param name
	 * @param lastName
	 * @param age
	 * @param address
	 * @param city
	 * @param country
	 * @param christmasGift
	 */

	public void newChild(String name, String lastName, int age, String address, String city, String country, String christmasGift, String typeKid) {
		if(typeKid.equalsIgnoreCase("GOOD")){
			goodKids.add(new Children(name, lastName, age, address, city, country, christmasGift, typeKid));
		}else if(typeKid.equalsIgnoreCase("BAD")){
			badKids.add(new Children(name, lastName, age, address, city, country, christmasGift, typeKid));
		}
		
	}

	/**
	 * 
	 * @param name
	 * @param lastName
	 */
	public void moveChild(int name, int lastName) {

	}

}