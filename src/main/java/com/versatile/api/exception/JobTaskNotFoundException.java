package com.versatile.api.exception;

public class JobTaskNotFoundException extends Exception {
    public JobTaskNotFoundException(int id) {
        super("Job task " + id + " not found");
    }
}
