package com.avm.order_management_service.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long orderId) {
        super("Order with ID " + orderId + " was not found.");
    }
}
