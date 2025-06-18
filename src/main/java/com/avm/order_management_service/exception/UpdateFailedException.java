package com.avm.order_management_service.exception;

public class UpdateFailedException extends RuntimeException {

    public UpdateFailedException(String message, Throwable cause) {
        super("Failed to update order: " + message, cause);
    }
}
