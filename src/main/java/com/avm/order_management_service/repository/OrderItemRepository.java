package com.avm.order_management_service.repository;

import com.avm.order_management_service.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Optional<OrderItem> findByOrderIdAndProductId(Long orderId, Long productId);
}