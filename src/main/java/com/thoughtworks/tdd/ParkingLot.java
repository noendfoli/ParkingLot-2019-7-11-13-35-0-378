package com.thoughtworks.tdd;

import java.util.LinkedList;
import java.util.List;

public class ParkingLot{
    private String parkingLotName;
    private static final int parkingLotCapitity = 10;
    private List<Car> parkingSpace = new LinkedList<>();
    private Boolean isFull = false;

    public ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }
    public Ticket parkingCar(Car car) {
        if(this.isFull){
            return null;
        }
        parkingSpace.add(car);
        if(parkingSpace.size()== parkingLotCapitity){
            isFull = true;
        }
        return new Ticket(car,false,this.getParkingLotName());
    }
    public double getParkingRate(){
        double parkingRate = 0;
        parkingRate = (double)(parkingLotCapitity-this.getParkingSpace().size())/parkingLotCapitity;
        return parkingRate;
    }
    Car getCarByTicket(Ticket ticket) {
        return ticket.getCorrespondCar();
    }

    List<Car> getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(List<Car> parkingSpace) {
        this.parkingSpace = parkingSpace;
    }


    Boolean getFull() {
        return isFull;
    }

    public void setFull(Boolean full) {
        isFull = full;
    }

    public ParkingLot() {
    }

    public ParkingLot(Boolean isFull) {
        this.isFull = isFull;
    }

    public ParkingLot(String parkingLotName, Boolean isFull) {
        this.parkingLotName = parkingLotName;
        this.isFull = isFull;
    }

    static int getParkingLotCapitity() {
        return parkingLotCapitity;
    }
}
