package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class ManagerTest {
    @Test
    void should_give_correspond_Ticket_when_manage_give_right_Car(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(false);
        parkingLotList.add(parkingLot);
        Manager manager = new Manager(parkingLotList);
        Car parkingcar = new Car("BMW");
        Ticket ticket = manager.parkingCar(parkingcar);
        //when
        Car getCar = manager.getCar(ticket);
        //then
        Assertions.assertEquals(parkingcar,getCar);
    }
}
