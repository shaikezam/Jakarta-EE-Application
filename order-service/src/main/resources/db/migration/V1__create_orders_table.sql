CREATE TABLE IF NOT EXISTS ORDERS (
  id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  price DOUBLE NOT NULL,
  date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  user_id BIGINT UNSIGNED NOT NULL
);

CREATE TABLE IF NOT EXISTS ORDER_PRODUCTS (
  id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT UNSIGNED,
  product_id BIGINT UNSIGNED,
  quantity INT NOT NULL,
  date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY order_product_unique (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES ORDERS(id)
);

INSERT INTO ORDERS (price, user_id) VALUES (2700.0, 1);
INSERT INTO ORDERS (price, user_id) VALUES (950.0, 2);

INSERT INTO ORDER_PRODUCTS (order_id, product_id, quantity) VALUES (1, 1, 2);  -- Order 1: 2x Smartphones
INSERT INTO ORDER_PRODUCTS (order_id, product_id, quantity) VALUES (1, 2, 1);  -- Order 1: 1x Laptop
INSERT INTO ORDER_PRODUCTS (order_id, product_id, quantity) VALUES (2, 3, 3);  -- Order 2: 3x Headphones
INSERT INTO ORDER_PRODUCTS (order_id, product_id, quantity) VALUES (2, 4, 1);  -- Order 2: 1x Smart Watch

