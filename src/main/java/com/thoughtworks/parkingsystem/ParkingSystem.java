package com.thoughtworks.parkingsystem;

public class ParkingSystem {
    private int numberOfSlots = 5;

    public ParkingSystem() {
    }

    public boolean park() {
        if(isSlotAvailable()) {
            return true;
        }
        return false;
    }

    private boolean isSlotAvailable() {
        if(numberOfSlots > 0) {
            return true;
        }
        return false;
    }
}
