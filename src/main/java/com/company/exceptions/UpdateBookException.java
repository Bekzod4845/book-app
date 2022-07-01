package com.company.exceptions;

public class UpdateBookException extends IllegalArgumentException {
    public UpdateBookException(String msg) {
        super(msg);
    }
}
