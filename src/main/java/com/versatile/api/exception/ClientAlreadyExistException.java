package com.versatile.api.exception;

public class ClientAlreadyExistException extends Throwable {
    public ClientAlreadyExistException(String name, Integer idClient) {
        super("Client with name " + name + " already exist " + idClient);
    }
}
