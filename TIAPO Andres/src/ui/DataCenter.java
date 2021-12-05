package ui;

import java.util.*;

import model.*;

public class DataCenter{
    private final String ERROR = "Invalid option";
    private Scanner sc;
    private ControllerDataCenter controller;
    public DataCenter(){
        sc = new Scanner(System.in);
        controller = new ControllerDataCenter();
    }
    /**
     * @author Andrés Pino
     * @param args main args
     */
    public static void main(String[] args){
        DataCenter obPpal = new DataCenter();
        int option = 0;

        do{
            option = obPpal.showMenu();
            obPpal.answer(option);
        }while(option != 0);
    }
    /**
     * This method called showMenu will show the menu in console
     * @return option The option the user selected 
     */
    public int showMenu(){
        System.out.println("Please, select an option: \n(1) List of available rooms\n(2) Rent a room\n(3) Un-rent room\n(4) Show rooms status\n(5) Simulate ON/OFF\n(6) Show map");
        int option = sc.nextInt();
        return option;
    }

    public void answer(int option){
        switch(option){
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                availableRooms();
                break;
            case 2:
                rentRoom();
                break;
            case 3: 
                cancelRent();
                break;
            case 4:
                System.out.println(controller.statusRoom());
                break;
            case 5:
                simulation();
                break;
            case 6:
                System.out.println(controller.showMatrix());
                break;
            default: 
                System.out.println(ERROR);
        }
    }
    /**
     * Calls the method in ControllerDataCenter to show the rooms that are available
     */
    public void availableRooms(){
        System.out.println(controller.availableRooms());
    }
 
    /**
     * This method let the user rent a room, and create the racks
     */
    public void rentRoom(){
        System.out.println("Enter the amount of rooms to rent: ");
        int qRooms = sc.nextInt();
 
        System.out.println("(1) For an enterprise \n(2) For investigation project");
        int option = sc.nextInt();
        sc.nextLine();
        String name, nit;
        switch(option){
            case 1:
                sc.nextLine();
                System.out.println("Enter the name of the enterprise: ");
                name = sc.nextLine();

                System.out.println("Enter the NIT of the enterprise: ");
                nit = sc.nextLine();
                infoServers(qRooms, name, nit);
                break;
            case 2:
                name = "University ICESI";
                System.out.println("Enter the ID of the project: ");
                nit = sc.nextLine();
                infoServers(qRooms, name, nit);
                break;

            default:
               System.out.println(ERROR);
        }
    }

    /**
     * This method let the user cancel a rent of a room
     */
    public void cancelRent(){
        System.out.println("(1) Rooms for an enterprise\n(2) Rooms for University");
        int option = sc.nextInt();

        switch(option){
            case 1:
                System.out.println("Enter the name of the enterprise: ");
                String nameC = sc.nextLine();
		        System.out.println(controller.cancelRent(nameC));
                break;
            case 2:
                System.out.println("Enter the ID Project");
                int id = sc.nextInt();
                System.out.println(controller.cancelRent(id));
                break;
        }
    }
    /**
     * This method get the information for a server from the user
     * @param qRooms It's the amount of rooms the user entered before
     * @param name It's the name of the enterprise
     * @param nit It's the NIT of the University, or of the enterprise
     */
    public void infoServers(int qRooms, String name, String nit){
        System.out.println("Enter the amount of servers: ");
        int num = sc.nextInt();

        ArrayList <Rack> rack = new ArrayList<>();
        for(int i = 0; i < num; i++){
            System.out.println("Enter the cache: ");
            double cache = sc.nextDouble();

            System.out.println("Enter the number of processors: ");
            int numProcessor = sc.nextInt();

            System.out.println("Enter the type of Processor \n(1) AMD \n(2) INTEL");
            int processorBrand = sc.nextInt();

            System.out.println("Enter the ram capacity: ");
            double ram = sc.nextDouble();

            System.out.println("Enter the disc amount: ");
            int discA = sc.nextInt();

            System.out.println("Enter the capacity of the disc: ");
            double discC = sc.nextDouble();
            
            rack.add(new Rack(processorBrand, cache, numProcessor, ram, discA, discC));
        }
	controller.searchRoom(qRooms).setRack(rack);
	System.out.println(controller.rentRoom(qRooms, name, nit, rack)); 
	
	
	
    }
    /**
     * There are two options to simulate: To turn off, or to turn On, it depends of the user's answer
     */
    public void simulation(){
        sc.nextLine();
        System.out.println("Do you want to simulate\n(1)ON \n(2)OFF");
        int option = sc.nextInt();
        
        onOFF(option);
    }
    /**
     * The user enter the letter with the option they want to simulate
     * @param option
     */
    public void onOFF(int option){
        sc.nextLine();
        String onOFF = "";
        if(option ==1){
            onOFF = "ON";
        }else if(option ==2){
            onOFF = "OFF";
        }
        sc.nextLine();
        System.out.println("Please select a letter: ");
        System.out.println(
        "(L) Turns " +  onOFF + " the first rooms of all hallways, along with the rooms of the first hallway\n" +
        "(Z) Turns " +  onOFF + " the room of the first and last hallway, along with the rooms of the reverse diagonal\n" + 
        "(H) Turns " +  onOFF + " rooms located in odd hallways\n" +
        "(O) Turns " +  onOFF + " the rooms located in the windows\n" +
        "(M) Turns " +  onOFF + " the rooms located in the column you want\n" +
        "(P) Turn " +  onOFF + " the hallways you want");
        String user = sc.nextLine();
        if(onOFF.equalsIgnoreCase("ON")){
            switch(user){
                case "L":
                    controller.optionLOn();
                break;
                case "Z":
                    controller.optionZOn();
                break;
                case "H":
                    controller.optionHOn();
                break;
                case "O":
                    controller.optionOn();
                break;
                case "M":
                    sc.nextLine();
                    System.out.println("Please enter the column you want to turn on (1-50)");
                    int column = sc.nextInt();
                    controller.optionMOn(column);
                break;
                case "P":
                    sc.nextLine();
                    System.out.println("Please enter the hallway you want to turn on (1-8)");
                    int hallway = sc.nextInt();
                    controller.optionPOn(hallway);
                break;
                default:
                    System.out.println(ERROR);
            }
        }

        if(onOFF.equalsIgnoreCase("OFF")){
            switch(user){
                case "L":
                    controller.optionLOff();
                break;
                case "Z":
                    controller.optionZOff();
                break;
                case "H":
                    controller.optionHOff();
                break;
                case "O":
                    controller.optionOff();
                break;
                case "M":
                    sc.nextLine();  
                    System.out.println("Please enter the column you want to turn off (1-50)");
                    int column = sc.nextInt();
                    controller.optionMOff(column);
                break;
                case "P":
                    sc.nextLine();
                    System.out.println("Please enter the hallway you want to turn off (1-8)");
                    int hallway = sc.nextInt();
                    controller.optionPOn(hallway);
                break;
                default:
                    System.out.println(ERROR);
            }
        }
    }
}