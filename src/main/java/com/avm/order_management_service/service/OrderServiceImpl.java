package com.avm.order_management_service.service;

import com.avm.order_management_service.entity.OrderItem;
import com.avm.order_management_service.entity.Product;
import com.avm.order_management_service.exception.ExceededQuantityException;
import com.avm.order_management_service.exception.InvalidQuantityException;
import com.avm.order_management_service.exception.OrderNotFoundException;
import com.avm.order_management_service.exception.ProductNotFoundExceptionInOrder;
import com.avm.order_management_service.repository.OrderItemRepository;
import com.avm.order_management_service.repository.OrderRepository;
import com.avm.order_management_service.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    @Override
    public void updateProductQuantityInOrder(Long orderId, Long productId, int newQuantity) {

        orderRepository.findById(orderId)
            .orElseThrow(() -> new OrderNotFoundException(orderId));

        OrderItem orderItem = orderItemRepository.findByOrderIdAndProductId(orderId, productId)
                .orElseThrow(() -> new ProductNotFoundExceptionInOrder(productId, orderId));

        if (newQuantity < 0) {
            throw new InvalidQuantityException(newQuantity);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found in database."));

        if (newQuantity > product.getAvailableQuantity()) {
            throw new ExceededQuantityException(newQuantity, product.getAvailableQuantity());
        }

        orderItem.setQuantity(newQuantity);
        orderItemRepository.save(orderItem);

    }
}
