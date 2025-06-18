# Order Management API

## Description
Spring Boot REST API for managing product orders for an e-commerce system, developed as a technical test solution.

## Features
- Update product quantities in existing orders
- Validate stock availability in real-time
- Business rule enforcement:
    - Prevent negative quantities
    - Check available stock before processing

## Technology Stack
- **Java 17**
- **Spring Boot 3.2**
- **H2 Database** (in-memory, loads test data automatically on startup)
- **SpringDoc OpenAPI 3** (Swagger documentation)


## Access Information

**API Documentation (Swagger UI)**  
http://localhost:8080/api/swagger-ui/index.html

**Database Console (H2)**  
http://localhost:8080/api/h2-console

**Connection Details**:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)