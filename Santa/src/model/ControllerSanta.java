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
			String christmasGift, int typeKid) {
		if (typeKid == 1) {
			goodKids.add(new Children(name, lastName, age, country, city, address, christmasGift, typeKid));
		} else if (typeKid == 2) {
			badKids.add(new Children(name, lastName, age, country, city, address, christmasGift, typeKid));
		}
	}

	/**
	 * 
	 * @param name
	 * @param string TODO
	 * @return alert
	 */
	public void moveChild(String name1) {
		boolean flag = false;
		Children children = null;

		for (int i = 0; i < goodKids.size() && flag == false; i++) {

			if (goodKids.get(i).getName().equals(name1)) {
				children = goodKids.get(i);

				flag = true;
				goodKids.remove(children);
				badKids.add(children);

			}
		}
		for (int c = 0; c < badKids.size() && flag == false; c++) {
			if (goodKids.get(c).getName().equals(name1)) {
				children = badKids.get(c);
				goodKids.remove(children);
				badKids.add(children);
				flag = true;
			}
		}
		if (children == null) {
			System.out.println("This child doesn't exist, please add a child first, or search again");
		} else {
			System.out.println("This child has been changed");
		}
	}

	/**
	 * 
	 * @param typeKid
	 * 
	 */
	public void showChildren(int lista) {
		if (lista == 1) {
			for (int i = 0; i < goodKids.size(); i++) {
				System.out.println(goodKids.get(i).toString());
			}
		} else if (lista == 2) {
			for (int i = 0; i < badKids.size(); i++) {
				System.out.println(badKids.get(i).toString());
			}
		}
	}
}