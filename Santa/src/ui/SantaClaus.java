package ui;

import java.util.Scanner;
import model.ControllerSanta;

/**
 * @author Andres Pino
 */
public class SantaClaus {
	private ControllerSanta control;
	static Scanner sc = new Scanner(System.in);

	/**
	 * Constructor of SantaClaus
	 */
	public SantaClaus() {
		control = new ControllerSanta();
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SantaClaus santa = new SantaClaus();
		int option = 0;

		do {
			System.out.println("Welcome to santa Claus program\nWhat do you want to do? \n" + "(1) Add new child\n"
					+ "(2) Move a child to other list\n" + "(3) Show list (GOOD or BAD)\n" + "(0) Sign out");
			option = sc.nextInt();
			sc.nextLine();
			santa.menu(option);
		} while (option != 0);

	}// Main

	/**
	 * 
	 * @param option It's the option entered by the user
	 */
	public void menu(int option) {
		switch (option) {
		case 0:
			System.out.println("See you later!");
			System.exit(0);
			break;
		case 1:
			addChild();
			break;
		case 2:
			moveChild();
			break;
		case 3:
			showList();
			break;
		default:
			System.out.println("This option is invalid");
			break;
		}
	}// menu

	/**
	 * This method is to add a child, the user enter all the values, then it take
	 * the newChild method to add that child to the ArrayList
	 */
	public void addChild() {
		System.out.println("Enter the name of the child: ");
		String name = sc.nextLine();

		System.out.println("Enter the last name of the child: ");
		String lastName = sc.nextLine();

		System.out.println("Enter the age of the child: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the country where the child lives: ");
		String country = sc.nextLine();

		System.out.println("Enter the city where the child lives: ");
		String city = sc.nextLine();

		System.out.println("Enter the address of the child: ");
		String address = sc.nextLine();

		System.out.println("What's the christmas gift does the kind want? ");
		String gift = sc.nextLine();

		System.out.println("What's the type of the kid? (GOOD/BAD)");
		String typeKid = sc.nextLine();

		control.newChild(name, lastName, age, country, city, address, gift, typeKid);

		System.out.println("This kid has been added successfully");
	}// addChild

	/**
	 * This method is to move a child, the user enter the name of the user, then it
	 * takes it to the moveChild method
	 */
	public void moveChild() {
		System.out.println("What's the name of the child you want to move?");
		String name = sc.nextLine();
		control.moveChild(name);
		System.out.println("This kid has been changed");
	}

	/**
	 * This method is to show the list of Goodkids, or badkids
	 */
	public void showList() {
		System.out.println("What list do you want to see? (GOOD/BAD)");
		String lista = sc.nextLine();
		control.showChildren(lista);

	}

}