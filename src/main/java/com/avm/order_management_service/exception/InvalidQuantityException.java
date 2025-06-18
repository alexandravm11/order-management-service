package com.avm.order_management_service.exception;

public class InvalidQuantityException extends RuntimeException {

    public InvalidQuantityException(int quantity) {
        super("Invalid quantity: " + quantity + ". Quantity must be zero or greater.");
    }
}
