package model;

import java.util.*;

public class ControllerSanta {

	private static ArrayList<Children> goodKids;
	private static ArrayList<Children> badKids;

	/**
	 * ControllerSanta constructor
	 */
	public ControllerSanta() {
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

	public void newChild(String name, String lastName, int age, String address, String city, String country,
			String christmasGift, String typeKid) {
		if (typeKid.equalsIgnoreCase("GOOD")) {
			goodKids.add(new Children(name, lastName, age, country, city, address, christmasGift, typeKid));
		} else if (typeKid.equalsIgnoreCase("BAD")) {
			badKids.add(new Children(name, lastName, age, country, city, address, christmasGift, typeKid));
		}
	}

	public void moveChild(String name) {
		boolean flag = false;
		String message = "It's not founded";

		for (int i = 0; i < goodKids.size(); i++) {

			if (goodKids.get(i).equals(name)) {
				Children children = goodKids.get(i);
				goodKids.remove(children);
				goodKids.add(children);
				flag = true;
				message = "Founded";
				System.out.println(message);

			}
		}
		for (int i = 0; i < badKids.size() && flag == false; i++) {
			Children children = badKids.get(i);
			badKids.remove(children);
			badKids.add(children);

		}
	}

	/**
	 * 
	 * @param name
	 * @param lastName
	 */
	public void showChildren(String typeKid) {
		if (typeKid.equalsIgnoreCase("GOOD")) {
			for (int i = 0; i < goodKids.size(); i++) {
				System.out.println(goodKids.get(i).toString());
			}
		} else if (typeKid.equalsIgnoreCase("BAD")) {
			for (int i = 0; i < badKids.size(); i++) {
				System.out.println(goodKids.get(i).toString());
			}
		}
	}
}