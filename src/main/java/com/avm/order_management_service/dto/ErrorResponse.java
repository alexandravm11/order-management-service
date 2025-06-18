package com.avm.order_management_service.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private int status;
    private String path;
    private LocalDateTime timestamp;
}
