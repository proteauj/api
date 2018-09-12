package com.versatile.api.exception;

public class ModelAlreadyExistException extends Exception {
    public ModelAlreadyExistException(String title, Integer id) {
        super("Model with title " + title + " already exist " + id);
    }
}
