package com.thoughtworks.tdd;

public class Ticket {
    private  Car correspondCar;
    private Boolean isUsed;
    private String parkingLotName;

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public Car getCorrespondCar() {
        return correspondCar;
    }

    public void setCorrespondCar(Car correspondCar) {
        this.correspondCar = correspondCar;
    }

    public Ticket(Car correspondCar) {
        this.correspondCar = correspondCar;
    }

    public Ticket(Car correspondCar, Boolean isUsed) {
        this.correspondCar = correspondCar;
        this.isUsed = isUsed;
    }

    public Ticket(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Ticket(Car correspondCar, Boolean isUsed, String parkingLotName) {
        this.correspondCar = correspondCar;
        this.isUsed = isUsed;
        this.parkingLotName = parkingLotName;
    }

    public Ticket() {
    }
}
