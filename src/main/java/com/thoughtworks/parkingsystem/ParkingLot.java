package com.thoughtworks.parkingsystem;

import com.thoughtworks.exceptions.AlreadyParkedException;
import com.thoughtworks.exceptions.ParkingLotFullException;

import java.util.ArrayList;

public class ParkingLot {

    private final int capacity;
    ArrayList<Parkable> parkedVehicles = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public void park(Parkable vehicle) throws ParkingLotFullException, AlreadyParkedException {
        if (!(isSlotAvailable())) {
            throw new ParkingLotFullException("Parking Lot is full");
        }
        if (!(isNotAlreadyParked(vehicle))) {
            throw new AlreadyParkedException("Vehicle is already Parked");
        }
        parkedVehicles.add(vehicle);
    }

    public boolean isParked(Parkable vehicle) {
        return parkedVehicles.contains(vehicle);
    }

    private boolean isNotAlreadyParked(Parkable vehicle) {
        return !(parkedVehicles.contains(vehicle));
    }

    private boolean isSlotAvailable() {
        return capacity > parkedVehicles.size();
    }
}
