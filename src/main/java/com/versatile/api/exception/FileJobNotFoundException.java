package com.versatile.api.exception;

public class FileJobNotFoundException extends Exception {
    public FileJobNotFoundException(int id) {
        super("File " + id + " not found");
    }
}
