package com.versatile.api.exception;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(int id) {
        super("Task " + id + " not found");
    }
}
