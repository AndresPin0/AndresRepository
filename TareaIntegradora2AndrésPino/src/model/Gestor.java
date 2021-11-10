package model;

public class Gestor {
	private Subscriber[] subscriber;
	private int cont;

	/**
	 * This is the Gestor constructor, here I set the size of the array subscriber,
	 * and cont to 0
	 *
	 */
	public Gestor() {
		cont = 0;
		subscriber = new Subscriber[50];
	}

	/**
	 * This boolean method let us know if there are similar ID registered
	 * 
	 * @param idSub This is the user value, the id he wants to add
	 * @return false If the id entered by the user is the same to other
	 */
	public boolean checkId(String idSub) {
		if (cont != 0) {
			for (int i = 0; i < cont; i++) {
				if (idSub.equals(subscriber[i].getIdSub())) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This boolean method let us know if there are free spaces left to add a new
	 * subscriber
	 * 
	 * @return true if cont is < 50, it means that there are free spaces to add
	 */
	public boolean checkSpace() {
		if (cont < 50) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method let us add a new Subscriber in the array with those param
	 * 
	 * @param id       This is the user ID
	 * @param name     This is the user name
	 * @param age      This is the user age
	 * @param hoursNum This is the user hours to consume
	 * @param typeSub  This is the enum that's in TypeSub class (NORMAL, GOLD,
	 *                 PLATINUM, DIAMOND)
	 * @param status   This is the user status
	 */
	public void addSub(String id, String name, int age, int hoursNum, TypeSub typeSub, String status) {
		subscriber[cont] = new Subscriber(id, name, age, hoursNum, typeSub, status);
		System.out.println(subscriber.length);
		cont++;
	}

	/**
	 * subsList This method will print all subscribers.
	 */
	public void subsList() {
		for (Subscriber subscriber1 : subscriber) {
			if (subscriber1 != null) {
				System.out.println("\nThe id is: " + subscriber1.getIdSub() + "\nSubs name is: "
						+ subscriber1.getNameSub() + "\nSubs age is: " + subscriber1.getAge() + "\nHours per week are: "
						+ subscriber1.getHoursNum() + "\nThe actual status is: " + subscriber1.getStatus()
						+ "\nThe type of subscription is: " + subscriber1.getTypeSub());
			}
		}
	}

	/**
	 * subsList This method will print the status of the subscribers
	 */
	public void users() {
		int act = 0;
		int dis = 0;
		for (int i = 0; i < cont; i++) {
			if (subscriber[i].getStatus() != null) {
				if (subscriber[i].getStatus().equals("ACTIVE")) {
					act += 1;
				} else if (subscriber[i].getStatus().equals("INACTIVE")) {
					dis += 1;
				}
			}
		}
		System.out.println("\nThere are " + act + " active subscribers");
		System.out.println("\nThere are " + dis + " inactive subscribers");
	}

	/**
	 * subsList This method will print the type of subscriptions of the registered
	 * users
	 */
	public void countTypeSubs() {
		int typeN = 0;
		int typeG = 0;
		int typeP = 0;
		int typeD = 0;
		for (int i = 0; i < cont; i++) {
			if (subscriber[i].getTypeSub() != null) {
				if (subscriber[i].getTypeSub() == TypeSub.NORMAL) {
					typeN++;
				} else if (subscriber[i].getTypeSub() == TypeSub.GOLD) {
					typeG++;
				} else if (subscriber[i].getTypeSub() == TypeSub.PLATINUM) {
					typeP++;
				} else if (subscriber[i].getTypeSub() == TypeSub.DIAMOND) {
					typeD++;
				}
			}
		}
		System.out.println("\nThere are " + typeN + " of subscription type NORMAL" + "\nThere are " + typeG
				+ " of subscription type GOLD" + "\nThere are " + typeP + " of subscription type PLATINUM"
				+ "\nThere are " + typeD + " of subscription type DIAMOND");
	}

	/**
	 * youngSub This method show the youngest subscriber with the most hours to
	 * consume
	 */
	public void youngSub() {
		int maxHours = 0;
		String infoSub = "";
		for (int i = 0; i < subscriber.length; i++) {
			if (subscriber[i] != null) {
				if (subscriber[i].getAge() < 18 && subscriber[i].getHoursNum() > maxHours) {
					infoSub = "\nThe id is: " + subscriber[i].getIdSub() + "\nSub's name is: "
							+ subscriber[i].getNameSub() + "\nSubs age is: " + subscriber[i].getAge()
							+ "\nHours per week are: " + subscriber[i].getHoursNum() + "\nThe type of subscription is: "
							+ subscriber[i].getTypeSub();
					maxHours = subscriber[i].getHoursNum();
				}
			}
		}
		System.out.println(infoSub);
	}

	/**
	 * This method let us get the amount of subs, in this case is 50
	 * 
	 * @return cont is that value of 50
	 */
	public int getAmountSubs() {
		return cont;
	}

	/**
	 * This method let us get the subs in the array Subscriber
	 * 
	 * @return subscriber is the array
	 */
	public Subscriber[] getAllSubs() {
		return subscriber;
	}

	/**
	 * This method let us search if the id given by the user is already registered
	 * to disable it
	 * 
	 * @param idSub It's the id entered by the user
	 * @return -1
	 */
	public int searchGivenId(String idSub) {
		for (int i = 0; i < cont; i++) {
			if (idSub.equals(subscriber[i].getIdSub())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This method let us disable a subscriber, to convert it to "INACTIVE", so
	 * first it search if the id is registered, if it doesn't will print that the
	 * sub doesn't exist
	 * 
	 * @param idSub It's the id entered by the user
	 * 
	 */
	public void disableSub(String idSub) {
		int index = searchGivenId(idSub);
		if (index != -1) {
			System.out.println(
					"This subscriber is now disable and the type of subscription has been changed to Normal...");
			String status = "INACTIVE";
			TypeSub typeSub = TypeSub.NORMAL;
			subscriber[index].setTypeSub(typeSub);
			subscriber[index].setStatus(status);
		} else {
			System.out.println("This subscriber doesn't exist");
		}
	}
}