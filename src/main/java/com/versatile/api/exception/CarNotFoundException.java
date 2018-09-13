package com.versatile.api.exception;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(int id) {
        super("Car " + id + " not found");
    }
}
