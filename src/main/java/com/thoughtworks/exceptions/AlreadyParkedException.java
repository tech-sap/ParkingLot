package com.thoughtworks.exceptions;

public class AlreadyParkedException extends Exception{
    public AlreadyParkedException(String errorMessage) {
        super(errorMessage);
    }
}
