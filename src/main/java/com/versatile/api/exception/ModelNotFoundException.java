package com.versatile.api.exception;

public class ModelNotFoundException extends Exception {
    public ModelNotFoundException(int id) {
        super("Model " + id + " not found");
    }
}
