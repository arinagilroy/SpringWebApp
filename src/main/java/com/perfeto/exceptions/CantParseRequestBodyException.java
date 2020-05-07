package com.perfeto.exceptions;

public class CantParseRequestBodyException extends RuntimeException {

    public CantParseRequestBodyException() {
        super("Can not parse JSON to Java object");
    }
}
