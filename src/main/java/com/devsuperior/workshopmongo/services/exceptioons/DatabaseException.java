package com.devsuperior.workshopmongo.services.exceptioons;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg) {
        super(msg);
    }
}