package com.easyschools.restservices.exceptions;

public class SsnIDExistException extends Exception {

    private static final long serialVersionUID = 1L;

    public SsnIDExistException(String message) {
        super(message);
    }
}
