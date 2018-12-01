package com.versatile.api.exception;

public class UserRoleNotFoundException extends Exception {
    public UserRoleNotFoundException(int id) {
        super("Employee role " + id + " not found");
    }
}
