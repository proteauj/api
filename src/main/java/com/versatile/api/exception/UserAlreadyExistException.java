package com.versatile.api.exception;

public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException(String email, int id) {
        super("Employee with email " + email + " already exist " + id);
    }
}
