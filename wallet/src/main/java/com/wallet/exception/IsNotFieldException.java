package com.wallet.exception;

public class IsNotFieldException extends RuntimeException {
    public IsNotFieldException() {
        super("Name, document, and email must not be null");
    }

    public IsNotFieldException(String message) {
        super(message);
    }
}
