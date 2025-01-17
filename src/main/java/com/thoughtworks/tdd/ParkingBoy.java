package com.thoughtworks.tdd;

import java.util.List;

public class ParkingBoy implements ParkingCarPerson {
    private String message;
    private List<ParkingLot> parkingLotList;

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket parkingCar(Car car) {
        Ticket ticket = new Ticket();
        if(car == null){
            throw new RuntimeException();
        }
        for(ParkingLot parkingLot:this.getParkingLotList()){
            if(!parkingLot.getFull()){
                ticket = parkingLot.parkingCar(car);
            }
        }
        if(ticket.getParkingLotName()==null){
            this.setMessage("Not enough position.");
            return null;
        }
        return ticket;
    }

    @Override
    public Car fetchCar(Ticket ticket) {
        Car car = new Car();
        if(ticket==null){
            this.setMessage("Please provide your parking ticket.");
            return null;
        }
        if(ticket.getCorrespondCar()==null || ticket.getUsed()){
            this.setMessage("Unrecognized parking ticket");
            return null;
        }
        for(ParkingLot parkingLot:this.getParkingLotList()){
            if(parkingLot.getParkingLotName().equals(ticket.getParkingLotName())){
                car = parkingLot.getCarByTicket(ticket);
            }
        }
        return car;
    }

    private List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
}
