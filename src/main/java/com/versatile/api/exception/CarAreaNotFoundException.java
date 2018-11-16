package com.versatile.api.exception;

public class CarAreaNotFoundException extends Exception {
    public CarAreaNotFoundException(int id) {
        super("Car area " + id + " not found");
    }

    public CarAreaNotFoundException(String code) {
        super("Car area with code " + code + " not found");
    }
}
