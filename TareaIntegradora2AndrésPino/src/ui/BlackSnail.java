package ui;

import model.Subscriber;
import model.TypeSub;
import java.util.*;
import model.Gestor;
import model.TypeMovie;
import model.GestorMovies;
import model.GestorSeries;

public class BlackSnail {
	private Gestor gestorSub;
	private GestorSeries series;
	private GestorMovies movies;
	public Scanner sc;
	private GestorSeries[] productSeries;
	private GestorMovies[] productMovies;
	private Subscriber[] subscriber;
	public static final int MAXSUBS = 50; // It's the array's size
	public static final int MAXPRODUCTS = 85;
	private String status;
	private static BlackSnail pc;

	public BlackSnail() {
		sc = new Scanner(System.in);
		subscriber = new Subscriber[MAXSUBS];
		productSeries = new GestorSeries[MAXPRODUCTS];
		productMovies = new GestorMovies[MAXPRODUCTS];
		gestorSub = new Gestor();
		series = new GestorSeries();
		movies = new GestorMovies();
	}

	/**
	 * 
	 * @param args is args
	 * @author Andrés Pino
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		pc = new BlackSnail();
		String nit = "";
		String website = "";
		String address = "";
		System.out.println("***Welcome to BlackSnail Channel***");
		System.out.println("What's the NIT?");
		nit = sc.nextLine();
		System.out.println("\nEnter the website of BlackSnail please");
		website = sc.nextLine();
		System.out.println("\nEnter the BlackSnail's address please");
		address = sc.nextLine();

		sc.nextLine();

		System.out.println("The info about this channel is: \nThe NIT: " + nit + "\nThe website: " + website
				+ "\nThe address: " + address);
		int option = 0;

		System.out.println("Thank you");
		do {
			option = pc.mainMenu();
			pc.menu(option, pc);
		} while (option != 0);
	}

	/**
	 * <p>
	 * <b>precondition: </b> This method is executed
	 * <p>
	 * <b>postcondition: </b> The method is called showMenu This will show the menu
	 * in main where's called
	 * 
	 * @return option returns the option that the user selected
	 */
	public int mainMenu() {
		int option = 0;
		System.out.println("This is the main menu");
		System.out.println("What would you like to do today? \n" + "(1) Show products menu \n"
				+ "(2) Show subscribers menu \n" + "(0) To sign out");

		option = sc.nextInt();
		return option;
	}

	public void menu(int menu, BlackSnail pc) {
		switch (menu) {
		case 0:
			System.out.println("See you later :)");

			break;
		case 1:
			pc.showProductsMenu();
			break;
		case 2:
			pc.showMenu();
			break;
		default:
			System.out.println("Error, invalid option");
		}
	}

	/**
	 * <p>
	 * <b>precondition: </b> This method is executed
	 * <p>
	 * <b>postcondition: </b> The method is called showMenu This will show the menu
	 * in main where's called
	 */
	public void showProductsMenu() {
		int option = 0;
		System.out.println("\nThis is the products menu");
		System.out.println("What would you like to do today? \n" + "(1) Add a new product (Max 85) \n"
				+ "(2) Search a product and show info about it \n" + "(3) Create next series season \n"
				+ "(4) List of movies for each category \n" + "(5) List of series and info about the last season \n"
				+ "(0) Go back to main menu");

		option = sc.nextInt();
		pc.menu2(option, pc);
	}

	/**
	 * <p>
	 * <b>precondition: </b> This method is executed
	 * <p>
	 * <b>postcondition: </b> The method is called showMenu This will show the menu
	 * in main where's called
	 * 
	 * @param option The option entered by the user in products menu
	 * @param pc     The BlackSnail object to call methods
	 */
	public void menu2(int option, BlackSnail pc) {
		sc.nextLine();
		switch (option) {
		case 0:
			pc.mainMenu();
			break;

		case 1:
			pc.addNewProduct();
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			// movies.moviesList();
			break;

		case 5:
			break;
		}
	}

	/**
	 * <p>
	 * <b>precondition: </b> This method is executed
	 * <p>
	 * <b>postcondition: </b> The method is called showMenu This will show the menu
	 * in main where's called
	 */
	public void showMenu() {
		int option = 0;
		System.out.println("\nThis is the Subscribers Menu");
		System.out.println("What would you like to do today? \n" + "(1) Add new Subscriber (Max 50) \n"
				+ "(2) Disable a subscriber \n" + "(3) List of subscribers for each type \n"
				+ "(4) To show the younger subscriber with the most hours to consume\n" + "(0) Go back to main menu");

		option = sc.nextInt();
		pc.menu3(option, pc);
	}

	/**
	 * <p>
	 * <b>precondition: </b> This method is called in the subscribers menu
	 * <p>
	 * <b>postcondition: </b> The method call the method the user selecteds setMenu
	 * This will call the method by the option the user selected before
	 * 
	 * @param option The option entered by the user before
	 * @param pc     The object I created in main, this allows to show the option
	 */
	public void menu3(int option, BlackSnail pc) {
		switch (option) {
		case 1:
			pc.addNewSub();
			break;
		case 2:
			pc.disSub();
			break;
		case 3:
			gestorSub.subsList();
			gestorSub.countTypeSubs();
			gestorSub.users();
			break;
		case 4:
			gestorSub.youngSub();
			break;

		default:
			System.out.println("Error, invalid option");
		}
	}

	/**
	 * <p>
	 * <b>precondition: </b> Called in the select subscriber menu
	 * <p>
	 * <b>postcondition: </b> The method is called, and let the user create a new
	 * subscriber addNewSub This is where the user can create a new sub
	 */
	public void addNewSub() {
		sc.nextLine();
		String id, name, confirm = "";
		int age, hoursNum, subType = 0;
		System.out.println("Don't forget that the maximum is 50 subscribers ");
		int cont = 0;
		boolean flag = false;
		boolean flag1 = false;

		for (int i = 0; i < subscriber.length && !flag && !flag1; i++) {

			if (gestorSub.checkSpace()) {
				System.out.println("What's your ID: ");

				id = sc.nextLine();

				if (gestorSub.checkId(id)) {
					System.out.println("\nWhat's your name? ");
					name = sc.nextLine();
					System.out.println("\nWhat's your Age? ");
					age = sc.nextInt();
					System.out.println("\nHow many hours per week are you going to use this app? ");
					hoursNum = sc.nextInt();
					System.out.println(
							"\nWhat's the Subscription type you want to buy: \n(1)Normal\n(2)Gold\n(3)Platinum\n(4)Diamond");
					subType = sc.nextInt();

					TypeSub typeSub = TypeSub.NORMAL;
					switch (subType) {
					case 1:
						typeSub = TypeSub.NORMAL;
						typeSub.name();
						break;
					case 2:
						typeSub = TypeSub.GOLD;
						typeSub.name();
						break;
					case 3:
						typeSub = TypeSub.PLATINUM;
						typeSub.name();
						break;
					case 4:
						typeSub = TypeSub.DIAMOND;
						typeSub.name();
						break;
					}
					System.out.println("\nNow your status is going to be ACTIVE");
					status = "ACTIVE";

					sc.nextLine();

					gestorSub.addSub(id, name, age, hoursNum, typeSub, status);
					cont = gestorSub.getAmountSubs();

					System.out.println("There are " + (MAXSUBS - cont) + " free spaces left to add...");
					System.out.println("\nAre you going to add another Subscriber? \nYES/NO");
					confirm = sc.nextLine();

					if (confirm.equalsIgnoreCase("No")) {

						System.out.println("See you later :)");
						pc.mainMenu();
						flag = true;
					} else if (confirm.equalsIgnoreCase("Yes")) {
						System.out.println("There you go");
					}

				} else {
					System.out.println("This user is already registered");
				}
			} else {
				System.out.println("There's no space left");
			}
		}
	}

	/**
	 * <p>
	 * <b>precondition: </b> Called in the select subscriber menu
	 * <p>
	 * <b>postcondition: </b> The method disable a subscriber disSub This method
	 * will disable a subscriber with the Id entered
	 */
	public void disSub() {
		System.out.println("What's the ID of the subscriber you want to disable? ");
		String idUser = sc.nextLine();
		gestorSub.disableSub(idUser);
	}

	/**
	 * <p>
	 * <b>precondition: </b> Called in the select product menu
	 * <p>
	 * <b>postcondition: </b> This mini menu is to select the product you want to
	 * add addNewProduct This is like the menu to select what product you want to
	 * create
	 */
	public void addNewProduct() {

		System.out.println("What are you going to create? (1) Movie / (2) Series");
		int choosen = sc.nextInt();
		if (choosen == 1) {
			pc.addNewMovie();
		} else if (choosen == 2) {
			pc.addNewSerie();
		}
	}

	/**
	 * <p>
	 * <b>precondition: </b> Called in the select product menu
	 * <p>
	 * <b>postcondition: </b> The method is called, and the user can put all the
	 * information about the new movie addNewMovie This is the method where the user
	 * can create a new movie
	 */
	public void addNewMovie() {
		boolean flag = false;
		int cont = 0;
		String day = "", month = "", year = "";
		String movieDate = "";
		String movieTitle = "";
		String director = "";
		String productorName = "";
		String sinopsis = "";
		String trailer = "";
		int typeMovie = 0;
		int minAge = 0;
		for (int i = 0; i < productMovies.length && !flag; i++) {
			if (movies.checkSpace()) {
				System.out.println("When is the premier date? DD/MM/YEAR");
				day = sc.nextLine();
				month = sc.nextLine();
				year = sc.nextLine();
				sc.nextLine();
				movieDate = day + "/" + month + "/" + year;

				System.out.println("What's the title of the movie?");
				movieTitle = sc.nextLine();

				System.out.println("What's the name of the director?");
				director = sc.nextLine();

				System.out.println("Who's the producer?");
				productorName = sc.nextLine();

				System.out.println("What's the sinopsis?");
				sinopsis = sc.nextLine();

				System.out.println("Enter the url of the trailer");
				trailer = sc.nextLine();

				System.out.println("What's the min age to watch " + movieTitle);
				minAge = sc.nextInt();

				System.out.println(
						"\nWhat's the category of the movie?: \n(1)Romantic\n(2)Action\n(3)Suspence\n(4)Horror\n(5)Comedy");
				typeMovie = sc.nextInt();

				TypeMovie movieType = TypeMovie.ROMANTIC;
				switch (typeMovie) {
				case 1:
					movieType = TypeMovie.ROMANTIC;
					movieType.name();
					break;
				case 2:
					movieType = TypeMovie.ACTION;
					movieType.name();
					break;
				case 3:
					movieType = TypeMovie.SUSPENCE;
					movieType.name();
					break;
				case 4:
					movieType = TypeMovie.HORROR;
					movieType.name();
					break;
				case 5:
					movieType = TypeMovie.COMEDY;
					movieType.name();
					break;
				}

				movies.addMovie(movieDate, movieTitle, director, sinopsis, productorName, trailer, movieType, minAge);
				cont = movies.getAmountMovies();
				System.out.println("There are " + (MAXPRODUCTS - cont) + " free spaces left to add...");
				System.out.println("\nAre you going to add another movie? \nYES/NO");
				sc.nextLine();
				String confirm = sc.nextLine();

				if (confirm.equalsIgnoreCase("No")) {

					System.out.println("See you later :)");
					pc.mainMenu();
					flag = true;
				} else if (confirm.equalsIgnoreCase("Yes")) {
					System.out.println("There you go");
				}
			}
		}
	}

	/**
	 * <p>
	 * <b>precondition: </b> Called in the select product menu
	 * <p>
	 * <b>postcondition: </b> The method is called, and the user can put all the
	 * information about the new serie addNewSerie This is the method where the user
	 * can create a new serie
	 */
	public void addNewSerie() {
		int cont = 0;
		String day = "", month = "", year = "";
		String firstEmision = "", seriesName = "";
		String nameProtagonist = "";
		String director = "";
		String sinopsis = "";
		String censoredOrNo = "";
		String reasonCensored = "";

		for (int i = 0; i < productSeries.length; i++) {
			if (series.checkSpace()) {
				System.out.println("What's the name of this serie?");
				sc.nextLine();
				seriesName = sc.nextLine();
				System.out.println("This works succesfully");

				System.out.println("What's the date of the first emition? DD/MM/YEAR");
				day = sc.nextLine();
				month = sc.nextLine();
				year = sc.nextLine();
				sc.nextLine();
				firstEmision = day + "/" + month + "/" + year;

				System.out.println("What's the name of the protagonist?");
				nameProtagonist = sc.nextLine();

				System.out.println("What's the name of the director?");
				director = sc.nextLine();

				System.out.println("What's the sinopsis?");
				sinopsis = sc.nextLine();

				System.out.println("This serie has been banned? ");
				censoredOrNo = sc.nextLine();

				if (censoredOrNo.equalsIgnoreCase("Yes")) {
					System.out.println("Why?");
					reasonCensored = sc.nextLine();
					series.addSeries(seriesName, firstEmision, nameProtagonist, director, sinopsis, reasonCensored);
				} else if (censoredOrNo.equalsIgnoreCase("NO")) {
					series.addSeries(seriesName, firstEmision, nameProtagonist, director, sinopsis, censoredOrNo);
				}

				cont = series.getAmountSeries();

				System.out.println("There are " + (MAXPRODUCTS - cont) + " free spaces left to add...");
				break;
			}
		}
	}
}