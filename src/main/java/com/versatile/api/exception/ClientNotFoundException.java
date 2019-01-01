package com.versatile.api.exception;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(int id) {
        super("Car " + id + " not found");
    }
}
