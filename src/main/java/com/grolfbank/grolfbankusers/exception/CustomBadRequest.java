package com.grolfbank.grolfbankusers.exception;

public class CustomBadRequest extends RuntimeException {
    public CustomBadRequest(String message) {
        super(message);
    }
}
