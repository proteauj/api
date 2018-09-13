package com.versatile.api.exception;

public class CarAlreadyExistException extends Throwable {
    public CarAlreadyExistException(String vin, Integer id) {
        super("Car with vin " + vin + " already exist " + id);
    }
}
