package ui;

import java.util.Scanner;
import model.ControllerSanta;

public class SantaClaus {
	private ControllerSanta control;
	static Scanner sc = new Scanner(System.in);

	public SantaClaus() {
		control = new ControllerSanta();
	}

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
		System.out.println("See you later!");

	}// Main

	public void menu(int option) {
		switch (option) {
		case 0:
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
	}

	public void addChild() {

		// String name = "";
		// String lastName = "";
		// int age = 0;
		// String address = "";
		// String city = "";
		// String country = "";
		// String gif = "";
		// String typeKid = "";

		System.out.println("Enter the name of the child: ");
		String name = sc.nextLine();
		System.out.println("Enter the last name of the child: ");
		String lastName = sc.nextLine();
		System.out.println("Enter the age of the child: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the address of the child: ");
		String address = sc.nextLine();
		System.out.println("Enter the city where the child lives: ");
		String city = sc.nextLine();
		System.out.println("Enter the country where the child lives: ");
		String country = sc.nextLine();
		System.out.println("What's the christmas gift does the kind want? ");
		String gif = sc.nextLine();
		System.out.println("What's the type of the kid? (GOOD/BAD)");
		String typeKid = sc.nextLine();

		control.newChild(name, lastName, age, address, city, country, gif, typeKid);

		System.out.println("This kid has been added successfully");

	}

	public void moveChild() {

	}

	public void showList() {

	}

}