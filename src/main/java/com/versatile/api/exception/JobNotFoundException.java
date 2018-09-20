package com.versatile.api.exception;

public class JobNotFoundException extends Exception {
    public JobNotFoundException(int id) {
        super("Job " + id + " not found");
    }
}
