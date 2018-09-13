package com.versatile.api.exception;

public class LogInNotFoundException extends Exception {
    public LogInNotFoundException(int id) {
        super("LogIn " + id + " not found");
    }
}
