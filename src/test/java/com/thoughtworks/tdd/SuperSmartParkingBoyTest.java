package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class SuperSmartParkingBoyTest {
    @Test
    void should_chose_second_parkingLot_when_first_full(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot("num1",true);
        Car car1 = new Car("BMW");
        Car car2 = new Car("auto");
        Car car3 = new Car("toyota");
        parkingLot.parkingCar(car1);
        parkingLot.parkingCar(car2);
        ParkingLot parkingLot2 = new ParkingLot("num2",false);
        parkingLot2.parkingCar(car3);
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot2);
        SuperSmartParkingBoy smartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        Car car = new Car();
        //when
        Ticket ticket =  smartParkingBoy.parkingCar(car);
        //then
        Assertions.assertEquals("num2",ticket.getParkingLotName());
    }
}
