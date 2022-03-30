package com.thoughtworks.parkingsystem;

import com.thoughtworks.exceptions.AlreadyParkedException;
import com.thoughtworks.exceptions.ParkingLotFullException;

import java.util.ArrayList;

public class ParkingLot {

    private final int capacity;
    ArrayList<Car> parkedCars = new ArrayList<Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Car car) throws ParkingLotFullException, AlreadyParkedException {
        if (!(isSlotAvailable())) {
            throw new ParkingLotFullException("Parking Lot is full");
        }
        if (!(isNotAlreadyParked(car))) {
            throw new AlreadyParkedException("Car is already Parked");
        }
        parkedCars.add(car);
        return true;
    }

    private boolean isNotAlreadyParked(Car car) {
        if (!(parkedCars.contains(car))) {
            return true;
        }
        return false;
    }

    private boolean isSlotAvailable() {
        if (capacity > parkedCars.size()) {
            return true;
        }
        return false;
    }
}
