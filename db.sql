CREATE DATABASE `demo`;
USE `demo`;

CREATE TABLE `customer` (
`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
`customer_id` VARCHAR(255),
`phone_number` VARCHAR(255),
`email` VARCHAR(255),
`address` VARCHAR(255),
`account` VARCHAR(255)
);

CREATE TABLE `account` (
`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
`account_number` VARCHAR(255),
`account_type` VARCHAR(255),
`account_name` VARCHAR(255),
`account_balance` DECIMAL(19,4)
);
