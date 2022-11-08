package com.devsuperior.workshopmongo.services.exceptioons;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}