package com.thoughtworks.exceptions;

public class ParkingLotFullException extends Exception{
    public ParkingLotFullException(String errorMessage) {
        super(errorMessage);
    }
}
