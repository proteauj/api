package com.versatile.api.exception;

public class StatusAlreadyExistException extends Exception {
    public StatusAlreadyExistException(String status, Integer id) {
        super("Status " + status + " already exist " + id);
    }
}
