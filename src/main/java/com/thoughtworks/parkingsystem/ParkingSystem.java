package com.thoughtworks.parkingsystem;

import java.util.ArrayList;

public class ParkingSystem {

    private int parkingLotCapacity;
    ArrayList<Car> parkingSlots = new ArrayList<Car>();
    public ParkingSystem(int capacity) {
        parkingLotCapacity = capacity;
    }

    public boolean park(Car car) {
        if(isSlotAvailable()) {
            parkingSlots.add(car);
            parkingLotCapacity--;
            return true;
        }
        return false;
    }

    private boolean isSlotAvailable() {
        if(parkingLotCapacity > 0) {
            return true;
        }
        return false;
    }
}
