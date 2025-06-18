package com.avm.order_management_service.exception;

public class ExceededQuantityException extends RuntimeException {

    public ExceededQuantityException(int requested, int available) {
        super("Requested quantity (" + requested + ") exceeds available quantity (" + available + ").");
    }
}
