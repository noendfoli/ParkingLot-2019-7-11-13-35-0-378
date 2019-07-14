package com.thoughtworks.tdd;

public class ParkingBoy {


    public Ticket getTicket(Car car, ParkingLot parkingLot) {
        return  parkingLot.parkingCar(car);
    }

    public Car getCar(Ticket ticket, ParkingLot parkingLot) {
        return parkingLot.getCarByTicket(ticket);
    }
}
