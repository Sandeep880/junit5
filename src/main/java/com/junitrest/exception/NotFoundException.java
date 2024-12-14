package com.junitrest.exception;

public class NotFoundException extends Exception{

    public NotFoundException(String message) {
        System.out.print(message);
    }
}
