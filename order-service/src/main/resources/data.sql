INSERT INTO orders (total_price, created, order_status)
VALUES
    (150.75, '2024-10-14 10:30:00', 1),  -- Assuming 1 represents a certain OrderStatus
    (250.50, '2024-10-14 11:00:00', 0),  -- Assuming 0 represents a different OrderStatus
    (99.99, '2024-10-13 15:45:00', 2);   -- Assuming 2 represents another OrderStatus

INSERT INTO order_item (sku_code, quantity, order_id)
VALUES
    ('SKU123', 2, 1),  -- Order item for order with ID 1
    ('SKU124', 3, 1),  -- Another order item for the same order (ID 1)
    ('SKU125', 1.5, 2), -- Order item for order with ID 2
    ('SKU126', 5, 3),  -- Order item for order with ID 3
    ('SKU127', 2.5, 3); -- Another order item for order with ID 3
