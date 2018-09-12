package com.versatile.api.exception;

public class MakeAlreadyExistException extends Throwable {
    public MakeAlreadyExistException(String title, Integer id) {
        super("Make with title " + title + " already exist " + id);
    }
}
