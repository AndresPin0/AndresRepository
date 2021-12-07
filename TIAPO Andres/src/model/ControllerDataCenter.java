package model;

import java.util.*;

public class ControllerDataCenter{
    private Room[][] rooms;
    private final String DONE = "This option has been done with success";
    private final String ERROR = "Error";

    /**
     * ControllerDataCenter contructor
     */
    public ControllerDataCenter(){
        this.rooms = new Room[8][50];
        createRoom();
    }
    
    /**
     * This method creates all rooms and calculate their price
     */
    public void createRoom(){
        int num = 1;
        double price = 250000;
        double discount = 0;
        double total = 0;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                boolean window = false;
                if(i == 0 || i == 7 || j == 0 || j ==50){
                    window = true;
                    discount = price *0.10;
                    total = price - discount;

                }else if( i == 6){
                    discount = price *0.15;
                    total = price - discount;
                }else if( i >= 1 && i <= 5){
                    discount = price * 0.25;
                    total = price + discount;
                }
                rooms[i][j] = new Room(num, j, i, total ,window);
                num++;
            }
        }
    }

    /**
     * Show the map of the matrix
     * @return msg is the matrix 
     */
    public String showMatrix(){
        String msg = "";
        msg += "Servers: \n";
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j<rooms[0].length; j++){
            msg += "["+rooms[i][j].getStatus() + "]";
            }
            msg += "\n";
        }
        
        return msg;
    }

    /**
     * Shows the available rooms
     * @return msg is the rooms info
     */
    public String availableRooms(){
        String msg = "";

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                Room tmp = rooms[i][j];
                if(!tmp.getRent()){
                    msg+="\n" + tmp.toString()+"\n";
                }
            }
        }
        return msg;
    }

    /**
     * Shows that msg
     * @return msg is the Status of all rooms
     */
    public String statusRoom(){
        String msg = "";
        String out = "";

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                Room tmp = rooms[i][j];
                if(!tmp.getRent()){
                    msg+= "\n*****" + tmp.toString()+ "*****\n";
                }
            }
        }
        
        out= out + "Servers: \n";
        for(int k = 0; k < rooms.length; k++){
            out += printNum(rooms);
        }
        return msg;
    }  
    
    /**
     * 
     * @param rooms it's the matrix of rooms
     * @return print 
     */
    public String printNum(Room[][] rooms){
        String print = "";
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                print += "[" + rooms[i][j] + "]";
            }
        }
        return print;
    }

    /**
     * This rents a room
     * @param num num of the room
     * @param name name of the enterprise
     * @param nit nit of the enterprise
     * @param rack info about servers
     * @return confirmation
     */
    public String rentRoom(int num, String name, String nit, ArrayList<Rack> rack){
        Room room = searchRoom(num);
        room.setEnterprise(new Enterprise(name, nit));
        room.setRack(rack);
        room.setRent(true);
        return "Process successfull";
    }

    /**
     * Confirmation to an empty room
     * @param num num of the room
     * @return empty rooms
     */
    public Room searchRoom(int num){
        Room room = null;
        boolean search = false;

        for(int i = 0; i < rooms.length && !search; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getNum() == num){
                    search = true;
                    room = rooms[i][j];
                }
            }
        }
        return room;
    }

    /**
     * Search a room, and cancel the rent of it
     * @param id id of the investigation project
     * @return confirmation message
     */
    public String cancelRent(int id){
        String msg = "This rooms doesn't exist";
        if(searchRoom(id)!=null){
            Room room = searchRoom(id);
            double process = room.cancelRent();
            msg = "This room has been canceled :) " + "The capacity was: " + process;
				
        }
        return msg;
    }

    /**
     * Cancel the rent for an enterprise
     * @param name name of the enterprise
     * @return confirmation message
     */
    public String cancelRent(String name){
        boolean succs = false;
        double process = 0;
        String msg = "This enterprise don't have rent rooms";
        for(int i = 0; i < rooms.length; i++){
            for( int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getEnterprise() != null){
                    if(rooms[i][j].getEnterprise().getName().equalsIgnoreCase(name)){
                        process+=rooms[i][j].cancelRent();
                        succs = true;
                    }
                }
            }
        }
        if(succs==true){
            msg = "This room has been canceled" + "The capacity was: " + process;;
        }
        return msg;
    }

    /**
     * I made two options for each letter, so this one simulates to turns On 
     */
    public void optionLOn(){
        boolean succs = false;
        String msg = ERROR;

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getHallway() == 0 || rooms[i][j].getRoom() == 0 ){
                    rooms[i][j].setStatus(true);
                    succs = true;
                }
            }
        }
        if(succs == true){
            msg = DONE;
        }
        System.out.println(msg);
    }

    /**
     * This one simulates to turns Off
     */
    public void optionLOff(){
        boolean succs = false;
        String msg = ERROR;

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getHallway() == 0 || rooms[i][j].getRoom() == 0 ){
                    rooms[i][j].setStatus(false);
                    succs = true;
                }
            }
        }
        if(succs == true){
            msg = DONE;
        }
        System.out.println(msg);
    }//First option

    /**
     * This simulates turns on
     */
    public void optionZOn(){   
        boolean succs = false;
        String msg = ERROR;
        Room[] inverse = new Room[rooms.length];
        for(int o = 0; o<rooms.length; o++){
            for(int l = 0; l<rooms[o].length; l++){
                if(o+l == rooms.length-1){
                    inverse[o] = rooms[o][l];
                }
                if(rooms[o][l].getNum() == 50 || rooms[o][l].getNum() == 100 || rooms[o][l].getNum() == 150 || rooms[o][l].getNum() == 200 || rooms[o][l].getNum() == 250 || rooms[o][l].getNum() == 300 || rooms[o][l].getNum() == 350 || rooms[o][l].getNum() == 400) {
                    rooms[o][l].setStatus(true);
                }
                
            }
        }

        visual(inverse);

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                
                if(rooms[i][j].getHallway() == 0 || rooms[i][j].getRoom() == 0 || rooms[i][j].getHallway() == 7 || rooms[i][j].getRoom() == 0){
                    rooms[i][j].setStatus(true);
                    succs = true;
                }
                
            }
        }
        if(succs == true){
            msg = DONE;
        }
        System.out.println(msg);

    }

    /**
     * This shows the rooms "/" of the reverse diagonal
     * @param pArray
     */
    public void visual(Room[] pArray){
        for(int i = 0; i< pArray.length; i++){
            System.out.println(pArray[i]);
        }
    }

    /**
     * Turns off 
     */
    public void optionZOff(){
        boolean succs = false;
        String msg = ERROR;
        Room[] inverse = new Room[rooms.length];
        for(int o = 0; o<rooms.length; o++){
            for(int l = 0; l<rooms[o].length; l++){
                inverse[o] = rooms[o][l];
                rooms[o][l].setStatus(false);
            }
        }
        visual(inverse);

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getHallway() == 0 || rooms[i][j].getRoom() == 0 || rooms[i][j].getHallway() == 7 || rooms[i][j].getRoom() == 0){
                    rooms[i][j].setStatus(false);
                    succs = true;
                }
            }
        }
        if(succs == true){
            msg = DONE;
        }
        System.out.println(msg);

    }//Second option

    /**
     * Turns on
     */
    public void optionHOn(){
        boolean succs = false;
        String msg = ERROR;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if((rooms[i][j].getHallway()%2) == 0){
                    rooms[i][j].setStatus(true);
                    succs = true;
                }
            }
        }
        if(succs == true){
            msg = DONE;
        }
        System.out.println(msg);
    }

    /**
     * Turns off
     */
    public void optionHOff(){
        boolean succs = false;
        String msg = ERROR;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if((rooms[i][j].getHallway()%2) == 0){
                    rooms[i][j].setStatus(false);
                    succs = true;
                }
            }
        }
        if(succs == true){
            msg = DONE;
        }
        System.out.println(msg);
    }//Third option

    /**
     * Turns on
     */
    public void optionOn(){
        boolean succs = false;
        String msg =ERROR;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getHallway() == 0 || rooms[i][j].getHallway() == 7 || rooms[i][j].getRoom() == 0 || rooms[i][j].getRoom() == 50){
                    rooms[i][j].setStatus(true);
                    succs = true;
                }
            }
        }
        if(succs == true){
          msg = DONE;
        }
        
        System.out.println(msg);
    }

    /**
     * Turns off
     */
    public void optionOff(){
        boolean succs = false;
        String msg = ERROR;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getHallway() == 0 || rooms[i][j].getHallway() == 7 || rooms[i][j].getRoom() == 0 || rooms[i][j].getRoom() == 50){
                    rooms[i][j].setStatus(false);
                    succs = true;
                }
            }
        }
        if(succs == true){
          msg = DONE;
        }
        
        System.out.println(msg);
    }//Fourth option

    /**
     * Turns on
     * @param column selected column
     */
    public void optionMOn(int column){
	    int aux = 0;
        String msg = DONE;
        for(int i = 0; i < rooms.length; i++){
		    rooms[i][aux-1].setStatus(true);
            }
        
        System.out.println(msg);

    }

    /**
     * Turns off
     * @param column Selected column
     */
    public void optionMOff(int column){
	    int aux = 0;
        String msg = DONE;
        for(int i = 0; i < rooms.length; i++){
		    rooms[i][aux-1].setStatus(false);
        }
        System.out.println(msg);

    }//Fifth option


    /**
     * Turns on
     * @param hallway Selected hallway
     */
    public void optionPOn(int hallway){
        boolean succs = false;
        String msg = ERROR;

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getHallway() == hallway-1 || rooms[i][j].getRoom() == 0 ){
                    rooms[i][j].setStatus(false);
                    succs = true;
                }
            }
        }

        if(succs == true){
          msg = DONE;
        }
        
        System.out.println(msg);

    }

    /**
     * Turns off
     * @param hallway Selected hallway
     */
    public void optionPOff(int hallway){
        boolean succs = false;
        String msg = ERROR;

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j].getHallway() == hallway-1 || rooms[i][j].getRoom() == 0 ){
                    rooms[i][j].setStatus(false);
                    succs = true;
                }
            }
        }

        if(succs == true){
          msg = DONE;
        }
        System.out.println(msg);

    }//Sixth option
}