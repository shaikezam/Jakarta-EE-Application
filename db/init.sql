create DATABASE mydb;

GRANT ALL PRIVILEGES ON `mydb`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON mydb.* TO 'admin'@'%' IDENTIFIED BY 'admin';
FLUSH PRIVILEGES;
