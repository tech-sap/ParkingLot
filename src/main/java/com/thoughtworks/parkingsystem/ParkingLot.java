package com.thoughtworks.parkingsystem;

import java.util.ArrayList;

public class ParkingLot {

    private int parkingLotCapacity;
    ArrayList<Car> parkedCars = new ArrayList<Car>();

    public ParkingLot(int capacity) {
        parkingLotCapacity = capacity;
    }

    public boolean park(Car car) {
        if (isSlotAvailable() && isNotAlreadyParked(car)) {
            parkedCars.add(car);
            parkingLotCapacity--;
            return true;
        }
        return false;
    }

    private boolean isNotAlreadyParked(Car car) {
        if (!(parkedCars.contains(car))) {
            return true;
        }
        return false;
    }

    private boolean isSlotAvailable() {
        if (parkingLotCapacity > 0) {
            return true;
        }
        return false;
    }
}
