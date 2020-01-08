package com.perfeto.exceptions;

public class CantRequestBodyException extends RuntimeException {

    public CantRequestBodyException() {
        super("Can not parse JSON to Java object");
    }
}
