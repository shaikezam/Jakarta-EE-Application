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
    VALUES ('Tablet', 500.00, 4, TRUE, 'A versatile tablet for work and entertainment.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Camera', 400.00, 6, TRUE, 'A high-quality camera for photography enthusiasts.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Smart Speaker', 100.00, 8, TRUE, 'A smart speaker with voice assistant capabilities.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('External Hard Drive', 150.00, 10, TRUE, 'An external hard drive for extra storage.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Wireless Mouse', 30.00, 12, TRUE, 'A wireless mouse for convenient use.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Gaming Keyboard', 80.00, 5, TRUE, 'A gaming keyboard with customizable keys.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Fitness Tracker', 50.00, 3, TRUE, 'A fitness tracker to monitor your activity.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Bluetooth Earphones', 40.00, 0, FALSE, 'Wireless earphones for music on the go.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Portable Charger', 20.00, 9, TRUE, 'A portable charger for your devices.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Computer Monitor', 200.00, 4, TRUE, 'A high-resolution computer monitor.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Wireless Router', 80.00, 6, TRUE, 'A wireless router for high-speed internet.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Bluetooth Speaker', 70.00, 8, TRUE, 'A portable Bluetooth speaker for music.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('USB Flash Drive', 10.00, 10, TRUE, 'A small USB drive for data storage.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Desk Lamp', 25.00, 12, TRUE, 'A desk lamp for brightening your workspace.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Wireless Headset', 60.00, 5, TRUE, 'A wireless headset for hands-free communication.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Portable SSD', 120.00, 3, TRUE, 'A portable solid-state drive for fast storage.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Smart TV', 700.00, 2, TRUE, 'A smart TV with streaming capabilities.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Computer Speakers', 50.00, 4, TRUE, 'Speakers for your computer setup.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Wireless Keyboard', 40.00, 6, TRUE, 'A wireless keyboard for comfortable typing.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Graphic Tablet', 150.00, 8, TRUE, 'A graphic tablet for digital artists.');

INSERT INTO PRODUCTS (name, price, quantity_available, is_available, description)
    VALUES ('Smart Thermostat', 100.00, 5, TRUE, 'A smart thermostat for home temperature control.');


