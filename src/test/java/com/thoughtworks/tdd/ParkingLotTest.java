package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    void should_get_a_ticket_when_give_car(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.getTicket(car,parkingLot);
        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    void should_get_a_Car_when_give_Ticket(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();
        //when
        Car car = parkingBoy.getCar(ticket,parkingLot);
        //then
        Assertions.assertNotNull(ticket);
    }

}
