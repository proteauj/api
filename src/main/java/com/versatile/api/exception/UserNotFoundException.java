package com.versatile.api.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(int id) {
        super("Employee " + id + " not found");
    }
}
