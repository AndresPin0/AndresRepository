package model;

import java.util.*;

public class ControllerDataCenter{
    private Room[][] rooms;

    public ControllerDataCenter(){
        this.rooms = new Room[8][50];
        createRoom();
    }

    public void createRoom(){
        int num = 1;

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                boolean window = false;
                if(i == 0 || i == 7 || j == 0 || j ==49){
                    window = true;
                }
                rooms[i][j] = new Room(num, j, i, window);
                num++;
            }
        }
        rooms[7][49].setStatus(true);
    }

    public String availableRooms(){
        String msg = "";

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                Room tmp = rooms[i][j];
                if(tmp.getRent()==false){
                    msg+="\n" + tmp.toString()+"\n";
                }
            }
        }
        return msg;
    }

    public String statusRoom(){
        String msg = "";

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                Room tmp = rooms[i][j];
                if(tmp.getRent()==false){
                    msg+= "///" + tmp.toString()+ "\n";
                }
            }
        }
        return msg;
    }

    public String rentRoom(int num, String name, String nit, ArrayList<Rack> rack){
        Room room = searchRoom(num);
        room.setEnterprise(new Enterprise(name, nit));
        room.setRack(rack);
        room.setRent(true);

        return "Process successfull";
    }

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

    public String cancelRent(int id){
        String msg = "This rooms doesn't exist";
        if(searchRoom(id)!=null){
            Room room = searchRoom(id);
            double process = room.cancelRent();
            msg = "This room has been canceled :)";
        }
        return msg;
    }

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
            msg = "This room has been canceled";
        }
        return msg;
    }
}