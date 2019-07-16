package com.thoughtworks.tdd;

public interface ParkingCarPerson<T>{
    Ticket parkingCar(Car car);
    Car fetchCar(Ticket ticket);
}
