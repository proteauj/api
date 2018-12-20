package com.versatile.api.exception;

public class JobTaskActivityNotFoundException extends Exception {
    public JobTaskActivityNotFoundException(int id) {
        super("Job task activity " + id + " not found");
    }
}
