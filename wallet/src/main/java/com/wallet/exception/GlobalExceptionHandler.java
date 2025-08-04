package com.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AmountIsNotPositionException.class)
    public ResponseEntity<ErrorResponse> AmountIsNotPositionException(AmountIsNotPositionException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CannotTransferWalletException.class)
    public ResponseEntity<ErrorResponse> CannotTransferWalletException(CannotTransferWalletException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorResponse> InsufficientBalanceException(InsufficientBalanceException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IsNotFieldException.class)
    public ResponseEntity<ErrorResponse> IsNotFieldException(IsNotFieldException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(String message, HttpStatus status) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), status.value(), message);
        return new ResponseEntity<>(error, status);
    }
}
