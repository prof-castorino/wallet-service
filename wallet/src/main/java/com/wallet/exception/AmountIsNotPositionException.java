package com.wallet.exception;

public class AmountIsNotPositionException extends RuntimeException {
    public AmountIsNotPositionException() {
        super("Amount must be positive.");
    }

    public AmountIsNotPositionException(String message) {
        super(message);
    }
}
