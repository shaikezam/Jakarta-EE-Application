CREATE TABLE IF NOT EXISTS PRODUCTS (
  id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  name TEXT NOT NULL,
  price DOUBLE NOT NULL,
  description TEXT
);

INSERT INTO PRODUCTS (name, price, description) VALUES ('Smartphone', 700.00, 'A high-end smartphone with advanced features.');
INSERT INTO PRODUCTS (name, price, description) VALUES ('Laptop', 1300.00, 'A powerful laptop for professional use.');
INSERT INTO PRODUCTS (name, price, description) VALUES ('Headphones', 200.00, 'Wireless headphones with noise-cancelling technology.');
INSERT INTO PRODUCTS (name, price, description) VALUES ('Smart Watch', 350.00, 'A smartwatch with fitness tracking and notifications.');
INSERT INTO PRODUCTS (name, price, description) VALUES ('Tablet', 500.9009, 'A versatile tablet for work and entertainment.');
