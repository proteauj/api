package com.versatile.api.exception;

public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException(String email, int id) {
        super("User with email " + email + " already exist " + id);
    }
}
