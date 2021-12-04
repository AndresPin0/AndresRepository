package ui;

import java.util.*;

import model.*;

public class DataCenter{
    private Scanner sc;
    private ControllerDataCenter controller;
    public DataCenter(){
        sc = new Scanner(System.in);
        controller = new ControllerDataCenter();
    }

    public static void main(String[] args){
        DataCenter obPpal = new DataCenter();

        int option = 0;

        do{
            option = obPpal.showMenu();
            obPpal.answer(option);
        }while(option != 0);
    }

    public int showMenu(){
        System.out.println("Please, select an option: \n(1) List of available rooms\n(2) Rent a room\n(3) Un-rent room\n(4) Show rooms status");
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
            default: 
                System.out.println("Invalid option, try again");
        }
    }

    public void availableRooms(){
        System.out.println(controller.availableRooms());
    }

    public void cancelRent(){
        System.out.println("(1) Rooms for an enterprise\n(2) Rooms for University");
        int option = sc.nextInt();

        switch(option){
            case 1:
                System.out.println("Enter the name of the enterprise: ");
                String nameC = sc.nextLine();
                break;
            case 2:
                System.out.println("Enter the ID Project");
                int id = sc.nextInt();
                break;
        }
    }

    public void rentRoom(){
        System.out.println("Enter the amount of rooms to rent: ");
        int qRooms = sc.nextInt();

        System.out.println("(1) For an enterprise \n(2) For investigation project");
        int option = sc.nextInt();
        sc.nextLine();
        String name, nit;
        switch(option){
            case 1: 
                System.out.println("Enter the name of the enterprise: ");
                name = sc.nextLine();

                System.out.println("Enter the NIT of the enterprise: ");
                nit = sc.nextLine();
                infoServers();
                break;
            case 2:
                name = "University ICESI";
                System.out.println("Enter the ID of the project: ");
                nit = sc.nextLine();
                infoServers();
                break;

            default:
               System.out.println("Invalid option");
        }
    }

    public void infoServers(){
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
    }

}