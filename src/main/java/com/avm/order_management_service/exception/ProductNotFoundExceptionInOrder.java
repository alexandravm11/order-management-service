package com.avm.order_management_service.exception;

public class ProductNotFoundExceptionInOrder extends RuntimeException{

    public ProductNotFoundExceptionInOrder(Long productId, Long orderId) {
        super("Product with ID " + productId + " is not part of Order ID " + orderId + ".");
    }
}
