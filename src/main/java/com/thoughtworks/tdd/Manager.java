package com.thoughtworks.tdd;

import java.util.List;

public class Manager implements OpreratingCar {
    private String message;
    private List<ParkingLot> parkingLotList;

    public Manager(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Ticket parkingCar(Car car) {
        Ticket ticket = new Ticket();
        if(car == null){
            throw new RuntimeException();
        }
        this.setMessage("Not enough position.");
        for(ParkingLot parkingLot:this.getParkingLotList()){
            if(!parkingLot.getFull()){
                ticket = parkingLot.parkingCar(car);
            }
        }
        return ticket;
    }

    @Override
    public Car getCar(Ticket ticket) {
        Car car = new Car();
        if(ticket==null){
            this.setMessage("Please provide your parking ticket.");
            return null;
        }
        if(ticket.getCorrespondCar()==null ||ticket.getUsed() == true){
            this.setMessage("Unrecognized parking ticket");
            return null;
        }
        for(ParkingLot parkingLot:this.getParkingLotList()){
            if(parkingLot.getParkingLotName()== ticket.getParkingLotName()){
                car = parkingLot.getCarByTicket(ticket);
            }
        }
        return car;
    }
}
