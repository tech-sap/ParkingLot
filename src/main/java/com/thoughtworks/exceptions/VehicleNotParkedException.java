package com.thoughtworks.exceptions;

public class VehicleNotParkedException extends Exception {
    public VehicleNotParkedException(String errorMessage) {
        super(errorMessage);
    }
}
