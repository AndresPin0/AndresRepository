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
    /**
     * Rooms constructor
     * @param num
     * @param room
     * @param hallway
     * @param price
     * @param window
     */
    public Room(int num, int room, int hallway, double price, boolean window) {
        this.num = num;
        this.price = price;
        this.rent = false;
        this.hallway = hallway;
        this.room = room;
        this.setRack(new ArrayList<>());
        this.setEnterprise(null);
        this.status = false;
        this.window = window;
    }
    /**
     * getter
     * @return num
     */
    public int getNum() {
        return num;
    }
    /**
     * setter
     * @param num num
     */
    public void setNum(int num) {
        this.num = num;
    }
    /**
     * getter
     * @return room
     */
    public int getRoom() {
        return room;
    }
    /**
     * setter
     * @param room room
     */
    public void setRoom(int room) {
        this.room = room;
    }
    /**
     * 
     * @return
     */
    public int getHallway() {
        return hallway;
    }
    /**
     * 
     * @param hallway
     */
    public void setHallway(int hallway) {
        this.hallway = hallway;
    }
    /**
     * getter
     * @return price
     */
    public double getPrice() {
        return price;
    }
    /**
     * setter
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * getter   
     * @return rent
     */
    public boolean getRent() {
        return rent;
    }
    /**
     * setter
     * @param rent rent
     */
    public void setRent(boolean rent) {
        this.rent = rent;
    }
    /**
     * isStatus
     * @return status
     */
    public boolean isStatus() {
        return status;
    }
    /**
     * setter
     * @param status status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    /**
     * is window
     * @return window
     */
    public boolean isWindow() {
        return window;
    }
    /**
     * setter
     * @param window window
     */
    public void setWindow(boolean window) {
        this.window = window;
    }
    /**
     * getter 
     * @return rack
     */
    public ArrayList<Rack> getRack() {
        return rack;
    }
    /**
     * setterArray rack
     * @param rack rack
     */
    public void setRack(ArrayList<Rack> rack) {
        this.rack = rack;
    }
    /**
     * getterEnterprise
     * @return
     */
    public Enterprise getEnterprise() {
        return enterprise;
    }
    /**
     * setter 
     * @param enterprise enterprise
     */
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    /**
     * getter rack
     * @return total process of a rack
     */
    public double getProcess(){
        int total = 0;
        for(int i = 0; i < rack.size(); i++){
            total += rack.get(i).getProcess();
        }
        return total;
    }
    /**
     * Cancel rent of a room
     * @return process
     */
    public double cancelRent(){
        double process = getProcess();
        rack.clear();
        this.enterprise=null;
        this.rent=false;
        this.status=false;

        return process;
    }
    /**
     * getter
     * @return status 
     */
    public String getStatus(){
        if(this.status == true){
            return "ON";
        }else{
            return "OFF";
        }
    }
    /**
     * ToString
     */
    @Override
    public String toString(){
        return "Num: " + getNum() + "\nPrice: " + getPrice() + "\nRent: " + getRent() + "\nHallway: " + getHallway() + "\nRoom: " + getRoom() 
        + "\nWindow: " + isWindow() + "\nStatus: " + getStatus(); 
    }
    /**
     * 
     * @return status
     */
    public String toStringStatus(){
        return "num: " + getNum() + "\nStatus: " + getStatus();
    }
}