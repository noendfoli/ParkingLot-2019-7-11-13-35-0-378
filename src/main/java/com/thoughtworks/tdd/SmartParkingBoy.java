package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.List;

public class SmartParkingBoy implements OpreratingCar {
    private String message;
    private List<ParkingLot> parkingLotList;

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket parkingCar(Car car) {
        Ticket ticket = new Ticket();
        if(car == null){
            throw new RuntimeException();
        }
        ParkingLot parkingLot = findMostPosionParkingLot(this.getParkingLotList());
        ticket = parkingLot.parkingCar(car);
        return ticket;
    }

    private ParkingLot findMostPosionParkingLot(List<ParkingLot> parkingLotList) {
        HashMap<Integer,ParkingLot> listHashMap = new HashMap<Integer, ParkingLot>();
        Integer mostPostion = 0;
        for(ParkingLot parkingLot:this.getParkingLotList()){
            if(!parkingLot.getFull()){
                Integer postion = Integer.valueOf(parkingLot.getParkingLotCapitity() - parkingLot.getParkingSpace().size());
                if(mostPostion< postion){
                    mostPostion = postion;
                }
                listHashMap.put(postion,parkingLot);
            }
        }
        return listHashMap.get(mostPostion);
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