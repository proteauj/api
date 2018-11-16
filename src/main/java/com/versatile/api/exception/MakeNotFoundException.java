package com.versatile.api.exception;

public class MakeNotFoundException extends Exception {
    public MakeNotFoundException(int id) {
        super("Make " + id + " not found");
    }

    public MakeNotFoundException(String code) {
        super("Make with code " + code + " not found");
    }
}
