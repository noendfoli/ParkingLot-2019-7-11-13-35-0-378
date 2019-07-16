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
        ParkingLot parkingLot = new ParkingLot("num1",false);
        parkingLotList.add(parkingLot);
        Manager manager = new Manager(parkingLotList);
        Car parkingcar = new Car("BMW");
        Ticket ticket = manager.parkingCar(parkingcar);
        //when
        Car getCar = manager.fetchCar(ticket);
        //then
        Assertions.assertEquals(parkingcar,getCar);
    }

    @Test
    void should_manager_specify_a_parking_boy_whith_managers_parkinglot(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot1 = new ParkingLot("partingLot1");
        ParkingLot parkingLot2 = new ParkingLot("partingLot2");
        ParkingLot parkingLot3 = new ParkingLot("partingLot3");
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingLotList.add(parkingLot3);
        List<ParkingBoy> parkingBoyList = new LinkedList<>();
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLotList);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLotList);
        ParkingBoy parkingBoy3 = new ParkingBoy(parkingLotList);
        parkingBoyList.add(parkingBoy1);
        parkingBoyList.add(parkingBoy2);
        parkingBoyList.add(parkingBoy3);
        Manager manager = new Manager(parkingLotList,parkingBoyList);
        Car car = new Car("BMW");
        //when
        Ticket ticket = manager.specifyPackingBoyPakingCar(parkingBoy1,car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_manager__receive_message_when_specify_parking_boy_parking_car(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot1 = new ParkingLot("partingLot1",true);
        ParkingLot parkingLot2 = new ParkingLot("partingLot2",true);
        ParkingLot parkingLot3 = new ParkingLot("partingLot3",true);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingLotList.add(parkingLot3);
        List<ParkingBoy> parkingBoyList = new LinkedList<>();
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLotList);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLotList);
        ParkingBoy parkingBoy3 = new ParkingBoy(parkingLotList);
        parkingBoyList.add(parkingBoy1);
        parkingBoyList.add(parkingBoy2);
        parkingBoyList.add(parkingBoy3);
        Manager manager = new Manager(parkingLotList,parkingBoyList);
        Car parkingcar = new Car("BMW");
        //when
        Ticket ticket = manager.specifyPackingBoyPakingCar(parkingBoy1,parkingcar);
        //then
        Assertions.assertEquals("all ParkLot full",manager.getMessage());
    }
}
