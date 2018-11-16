package com.versatile.api.exception;

public class ModelNotFoundException extends Exception {
    public ModelNotFoundException(int id) {
        super("Model " + id + " not found");
    }

    public ModelNotFoundException(String code) {
        super("Model with code " + code + " not found");
    }
}
