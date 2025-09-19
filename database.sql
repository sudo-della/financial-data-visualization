CREATE DATABASE financial_data;
USE financial_data;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE financial_records (
    record_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    year INT,
    month VARCHAR(20),
    amount DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
    
);