package com.avm.order_management_service.controller;

import com.avm.order_management_service.dto.UpdateQuantityRequest;
import com.avm.order_management_service.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
@Tag(name = "Order Management", description = "Endpoints for managing orders and products")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Update product quantity in an order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Quantity updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid quantity or exceeds available quantity"),
            @ApiResponse(responseCode = "404", description = "Order or product not found in order"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{orderId}/products/{productId}")
    public ResponseEntity<Void> updateProductQuantity(
            @PathVariable Long orderId,
            @PathVariable Long productId,
            @RequestBody UpdateQuantityRequest request) {

        orderService.updateProductQuantityInOrder(orderId, productId, request.getQuantity());
        return ResponseEntity.noContent().build();
    }
}
