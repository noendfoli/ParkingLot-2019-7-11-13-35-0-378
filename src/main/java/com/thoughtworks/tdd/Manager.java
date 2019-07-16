package com.thoughtworks.tdd;

import java.util.List;

public class Manager implements ParkingCarPerson {
    private String message;
    private List<ParkingLot> parkingLotList;
    private List<ParkingBoy> parkingBoyList;

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public void setParkingBoyList(List<ParkingBoy> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    public Manager(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Manager(List<ParkingLot> parkingLotList, List<ParkingBoy> parkingBoyList) {
        this.parkingLotList = parkingLotList;
        this.parkingBoyList = parkingBoyList;
    }

    private List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
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
    public Ticket specifyPackingBoyPakingCar(ParkingBoy parkingBoy,Car car){
        if(this.getParkingBoyList().contains(parkingBoy)){
             if(parkingBoy.parkingCar(car)==null){
                 this.setMessage("all ParkLot full");
             }else {
                 return parkingBoy.parkingCar(car);
             }
        }
        return null;
    }
}
