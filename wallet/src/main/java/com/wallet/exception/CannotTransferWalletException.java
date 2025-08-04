package com.wallet.exception;

public class CannotTransferWalletException extends RuntimeException {
    public CannotTransferWalletException() {
        super("Cannot transfer to same wallet");
    }

    public CannotTransferWalletException(String message) {
        super(message);
    }
}
