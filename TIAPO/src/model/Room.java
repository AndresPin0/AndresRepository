package model;

import java.util.*;

public class Room{

    private int num;
    private int room;
    private int hallway;
    private double price;
    private boolean rent;
    private boolean status;
    private boolean window;
    private ArrayList <Rack> rack;
    private Enterprise enterprise;

    public Room(int num, int room, int hallway, boolean window) {
        this.num = num;
        this.price = 0;
        this.rent = false;
        this.hallway = hallway;
        this.room = room;
        this.setRack(new ArrayList<>());
        this.setEnterprise(null);
        this.status = false;
        this.window = window;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getHallway() {
        return hallway;
    }

    public void setHallway(int hallway) {
        this.hallway = hallway;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isWindow() {
        return window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

    public ArrayList<Rack> getRack() {
        return rack;
    }

    public void setRack(ArrayList<Rack> rack) {
        this.rack = rack;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    public double getProcess(){
        int total = 0;
        for(int i = 0; i < rack.size(); i++){
            total += rack.get(i).getProcess();
        }
        return total;
    }

    public double cancelRent(){
        double process = getProcess();
        rack.clear();
        this.enterprise=null;
        this.rent=false;
        this.status=false;

        return process;
    }

    public String getStatus(){
        if(this.status == true){
            return "ON";
        }else{
            return "OFF";
        }
    }

    @Override
    public String toString(){
        return "Num: " + getNum() + "\nPrice: " + getPrice() + "\nRent: " + getRent() + "\nHallway: " + getHallway() + "\nRoom: " + getRoom() 
        + "\nWindow: " + isWindow() + "\nStatus: " + getStatus(); 
    }

    public String toStringStatus(){
        return "num: " + getNum() + "\nStatus: " + getStatus();
    }
}