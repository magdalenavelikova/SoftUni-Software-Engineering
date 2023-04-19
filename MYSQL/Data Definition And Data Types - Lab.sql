
CREATE DATABASE `gamebar` ;
USE `gamebar`;
/*Create Tables*/
CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL
);
CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL
);
CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`category_id` INT NOT NULL
);
/* Insert Data in Tables*/
INSERT INTO `employees`
VALUES
(1, 'TEST','TEST' ),
(2, 'TEST','TEST' ),
(3, 'TEST','TEST' );

SELECT * FROM `employees`;

/* Alter Table*/
ALTER TABLE `employees`
ADD COLUMN `middle_name` VARCHAR(20);

/*Adding Constraints*/

ALTER TABLE `products`
ADD CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`);

/*Modifying Columns*/
ALTER TABLE `employees`
MODIFY COLUMN `middle_name` VARCHAR(100);


 