package com.grolfbank.users.exception;

public class CustomBadRequest extends RuntimeException {
    public CustomBadRequest(String message) {
        super(message);
    }
}
