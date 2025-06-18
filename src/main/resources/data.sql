INSERT INTO product (name, price, available_quantity) VALUES
('Laptop', 3000.00, 5),
('Mouse', 150.00, 5),
('Teclado', 20.00, 5);

INSERT INTO orders (created_at) VALUES (CURRENT_TIMESTAMP);

INSERT INTO order_item (order_id, product_id, quantity) VALUES
(1, 1, 1),
(1, 2, 2);
