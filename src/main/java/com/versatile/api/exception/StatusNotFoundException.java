package com.versatile.api.exception;

public class StatusNotFoundException extends Exception {
    public StatusNotFoundException(int id) {
        super("Status " + id + " not found");
    }
}
