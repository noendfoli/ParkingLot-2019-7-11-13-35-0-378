package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class ParkingBoyTest {
    @Test
    void should_get_a_ticket_when_give_car(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(false);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    void should_get_a_Car_when_give_Ticket(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(false);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = new Ticket();
        //when
        Car car = parkingBoy.getCar(ticket);
        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    void should_give_correspond_Ticket_when_give_right_Car(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(false);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car parkingcar = new Car("BMW");
        Ticket ticket = parkingBoy.parkingCar(parkingcar);
        //when
        Car getCar = parkingBoy.getCar(ticket);
        //then
        Assertions.assertEquals(parkingcar,getCar);
    }
    @Test
    void should_get_a_Car_when_give_correspond_Ticket(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(false);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = new Ticket();
        //when
        Car car = parkingBoy.getCar(ticket);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_not_a_Car_when_give_wrong_Ticket(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(false);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = new Ticket(true);
        //when
        Car car = parkingBoy.getCar(ticket);
        //then
        Assertions.assertNull(car);
    }

    @Test
    void should_not_a_Car_when_give_used_Ticket(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(false);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = new Ticket();
        //when
        Car car = parkingBoy.getCar(ticket);
        //then
        Assertions.assertNull(car);
    }

    @Test
    void should_not_get_a_ticket_when_parkingLog_full(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(true);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = new Ticket();
        //when
        Car car = parkingBoy.getCar(ticket);
        //then
        Assertions.assertNull(car);
    }
    @Test
    void should_failed_when_park_null_car_to_parking_boy(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(true);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = null;

        //when//then
        Assertions.assertThrows(RuntimeException.class,()->{
           parkingBoy.parkingCar(car);
        });
    }

    @Test
    void should_get_a_message_when_parking_a_wrong_tiket(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(true);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = new Ticket();
        //when
        parkingBoy.getCar(ticket);
        //then
        Assertions.assertEquals("Unrecognized parking ticket",parkingBoy.getMessage());
    }

    @Test
    void should_get_a_message_when_not_give_a_car_for_paring(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(true);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        //when
        parkingBoy.getCar(null);
        //then
        Assertions.assertEquals("Please provide your parking ticket.",parkingBoy.getMessage());
    }

    @Test
    void should_get_a_message_when_parking_lot_full(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot(true);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        //when
        parkingBoy.parkingCar(car);
        //then
        Assertions.assertEquals("Not enough position.",parkingBoy.getMessage());
    }
    @Test
    void should_chose_second_parkingLot_when_first_full(){
        //Given
        List<ParkingLot> parkingLotList = new LinkedList<>();
        ParkingLot parkingLot = new ParkingLot("num1",true);
        ParkingLot parkingLot2 = new ParkingLot("num2",false);
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        //when
        Ticket ticket =  parkingBoy.parkingCar(car);
        //then
        Assertions.assertEquals("num2",ticket.getParkingLotName());
    }
}
