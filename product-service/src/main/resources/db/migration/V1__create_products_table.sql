CREATE TABLE IF NOT EXISTS PRODUCTS (
  id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  name TEXT NOT NULL,
  price DOUBLE NOT NULL,
  quantity_available INT NOT NULL,
  is_available BOOLEAN NOT NULL,
  description TEXT
);

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Smartphone', 700.00, 5, TRUE, 'A high-end smartphone with advanced features.');
INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Laptop', 1300.00, 3, TRUE, 'A powerful laptop for professional use.');
INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Headphones', 200.00, 2, TRUE, 'Wireless headphones with noise-cancelling technology.');
INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Smart Watch', 350.00, 0, FALSE, 'A smartwatch with fitness tracking and notifications.');
INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Tablet', 500.9009, 4, TRUE, 'A versatile tablet for work and entertainment.');

