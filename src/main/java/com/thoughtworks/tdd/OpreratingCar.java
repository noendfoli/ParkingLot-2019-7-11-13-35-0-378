package com.thoughtworks.tdd;

public interface OpreratingCar <T>{
    Ticket parkingCar(Car car);
    Car getCar(Ticket ticket);
}
