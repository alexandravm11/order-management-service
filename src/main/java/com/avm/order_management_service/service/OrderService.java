package com.avm.order_management_service.service;

public interface OrderService {

    public void updateProductQuantityInOrder(Long orderId, Long productId, int newQuantity);
}
