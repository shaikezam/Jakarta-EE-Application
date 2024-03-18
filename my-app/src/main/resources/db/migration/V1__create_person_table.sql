CREATE TABLE Person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO Person (name) VALUES ('Alice'), ('Bob'), ('Charlie');