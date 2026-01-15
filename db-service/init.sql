create DATABASE order_service;
create DATABASE product_service;


GRANT ALL PRIVILEGES ON `order_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON order_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON `product_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON product_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
FLUSH PRIVILEGES;
