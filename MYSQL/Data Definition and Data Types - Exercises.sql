CREATE DATABASE `minions`;
#1
CREATE TABLE `minions` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `age` VARCHAR(50)
);

CREATE TABLE `towns` (
    `town_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);


#2
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (town_id)
REFERENCES `towns`(`id`);

#3
INSERT INTO `towns`
VALUES
(1,	'Sofia'),
(2,	'Plovdiv'),
(3,	'Varna');

INSERT INTO `minions`
VALUES
(1,'Kevin',22,1),
(2,'Bob',15,3),
(3,	'Steward',NULL,2);

#4
TRUNCATE `minions`;

#5
DROP TABLE `minions`;
DROP TABLE `towns`;

#6
CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR( 200) NOT NULL,
`picture` BLOB,
`height` FLOAT (5,2),
`weight` FLOAT (5,2),
`gender` CHAR NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);
INSERT INTO `people`
VALUES
(1,'test1', null, 180, 50,'f','2023-04-18', 'empty'),
(2,'test1', null, 180, 50,'f','2023-04-18', 'empty'),
(3,'test1', null, 180, 50,'f','2023-04-18', 'empty'),
(4,'test1', null, 180, 50,'f','2023-04-18', 'empty'),
(5,'test1', null, 180, 50,'f','2023-04-18', 'empty');

#7

CREATE TABLE `users` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOL
 );
INSERT INTO `users`
VALUES
(1,'test','df123',null,'2023-04-18 10:10:00',0),
(2,'test1','df123',null,'2023-04-18 10:10:00',0),
(3,'test2','df123',null,'2023-04-18 10:10:00',0),
(4,'test3','df123',null,'2023-04-18 10:10:00',0),
(5,'test4','df123',null,'2023-04-18 10:10:00',0);

#8
ALTER TABLE `users` 
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`, `username`);

#9
ALTER TABLE `users` 
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME NULL DEFAULT now() ;

#10
ALTER TABLE `users` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`),
ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE;

#11

CREATE DATABASE `movies`;
CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(40) NOT NULL,
`notes` TEXT
);
INSERT INTO `directors`
VALUES
(1, 'Oliver Stone', 'some text'),
(2, 'Oliver Stone', 'some text'),
(3, 'Oliver Stone', 'some text'),
(4, 'Oliver Stone', 'some text'),
(5, 'Oliver Stone', 'some text');

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` TEXT);

INSERT INTO `genres`
VALUES
(1, 'action', 'some text'),
(2, 'animation', 'some text'),
(3, 'action', 'some text'),
(4, 'action', 'some text'),
(5, 'action', 'some text');

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);
INSERT INTO `categories`
VALUES
(1, 'kids', 'some text'),
(2, 'kids', 'some text'),
(3, 'kids', 'some text'),
(4, 'kids', 'some text'),
(5, 'kids', 'some text');

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL, 
`director_id` INT NOT NULL, 
`copyright_year` YEAR,
`length` FLOAT NOT NULL,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` INT NOT NULL,
`notes` TEXT
);
INSERT INTO `movies`
VALUES
(1, 'RANGO', 1, 2003, 1.36, 1, 1, 100, 'some text'),
(2, 'RANGO', 1, 2003, 1.36, 1, 1, 100, 'some text'),
(3, 'RANGO', 1, 2003, 1.36, 1, 1, 100, 'some text'),
(4, 'RANGO', 1, 2003, 1.36, 1, 1, 100, 'some text'),
(5, 'RANGO', 1, 2003, 1.36, 1, 1, 100, 'some text');


#12
CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(50) NOT NULL,
`daily_rate` INT NOT NULL,
`weekly_rate` INT NOT NULL,
`monthly_rate` INT NOT NULL,
`weekend_rate` INT NOT NULL);

INSERT INTO `categories`
VALUES
(1, 'CAR', 10, 50, 100, 80),
(2, 'BUS', 10, 50, 100, 80),
(3, 'CARAVAN', 10, 50, 100, 80);

CREATE TABLE `cars` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(10) NOT NULL,
`make` VARCHAR(30) NOT NULL,
`model` VARCHAR(30) NOT NULL,
`car_year` YEAR NOT NULL,
`category_id` INT NOT NULL,
`doors` INT NOT NULL,
`picture` BLOB,
`car_condition` VARCHAR(20) NOT NULL,
`available` BOOL);

INSERT INTO `cars`
VALUES
(1, 'V2046TK', 'OPEL', 'CORSA', 2010, 1, 5, NULL, 'NEW', 1),
(2, 'V2046TK', 'OPEL', 'CORSA', 2010, 1, 5, NULL, 'NEW', 1),
(3, 'V2046TK', 'OPEL', 'CORSA', 2010, 1, 5, NULL, 'NEW', 1);


CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL, 
`last_name` VARCHAR(30) NOT NULL, 
`title` VARCHAR(20) NOT NULL,
`notes` TEXT);

INSERT INTO `employees`
VALUES
(1, 'IVAN', 'IVANOV', 'SALES MANAGER', 'SOME TEXT'),
(2, 'IVAN', 'IVANOV', 'SALES MANAGER', 'SOME TEXT'),
(3, 'IVAN', 'IVANOV', 'SALES MANAGER', 'SOME TEXT');


CREATE TABLE `customers` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` VARCHAR(30) NOT NULL,
`full_name` VARCHAR(60) NOT NULL,
 `address` VARCHAR(100) NOT NULL,
 `city` VARCHAR(30) NOT NULL,
 `zip_code` VARCHAR(10) NOT NULL, 
 `notes` TEXT);
 
INSERT INTO `customers`
VALUES
(1, '545646464', 'IVAN IVANOV', 'STR JGOOIJTR', 'VARNA', '9000','SOME TEXT'),
(2, '545646464', 'IVAN IVANOV', 'STR JGOOIJTR', 'VARNA', '9000','SOME TEXT'),
(3, '545646464', 'IVAN IVANOV', 'STR JGOOIJTR', 'VARNA', '9000','SOME TEXT');



CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
 `employee_id`  INT NOT NULL,
 `customer_id`  INT NOT NULL,
 `car_id`  INT NOT NULL,
 `car_condition` VARCHAR(10) NOT NULL, 
 `tank_level` VARCHAR(10) NOT NULL,
 `kilometrage_start`  INT NOT NULL, 
 `kilometrage_end`  INT NOT NULL, 
 `total_kilometrage`  INT NOT NULL, 
 `start_date` DATE NOT NULL, 
 `end_date` DATE NOT NULL, 
 `total_days`  INT NOT NULL, 
 `rate_applied`  INT NOT NULL, 
 `tax_rate` FLOAT NOT NULL,
 `order_status` VARCHAR(10) NOT NULL,
 `notes` TEXT);

INSERT INTO `rental_orders`
VALUES
(1, 1, 1,1, 'NEW', 'FULL',1000, 1000, 200000,'2023-01-01','2023-10-01', 10, 100,100,'rent', NULL),
(2, 1, 1,1, 'NEW', 'FULL',1000, 1000, 200000,'2023-01-01','2023-10-01', 10, 100,100,'rent', NULL),
(3, 1, 1,1, 'NEW', 'FULL',1000, 1000, 200000,'2023-01-01','2023-10-01', 10, 100,100,'rent', NULL);


#13
CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(40) NOT NULL);
 
CREATE TABLE `addresses` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `address_text` VARCHAR(80) NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT pk_addresses_towns FOREIGN KEY (`town_id`)
        REFERENCES `towns` (`id`)
);
 
CREATE TABLE `departments` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(40) NOT NULL);
 
CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
 `first_name` VARCHAR(40) NOT NULL,
 `middle_name` VARCHAR(40) NOT NULL, 
 `last_name` VARCHAR(40) NOT NULL,
 `job_title` VARCHAR(40) ,
 `department_id` INT NOT NULL,
 `hire_date` DATE NOT NULL,
 `salary` DECIMAL(10,2),
 `address_id` INT NOT NULL,
 CONSTRAINT pk_employees_departments
 FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`) ,
 CONSTRAINT pk_employees_addresses
 FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`) );

INSERT INTO `towns`(`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO  `departments`(`name`)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO  `employees`
VALUES
(1, 'Ivan', 'Ivanov', 'Ivanov',	'.NET Developer',	4, '2013-02-01', 3500.00, null),
(2, 'Petar', 'Petrov', 'Petrov',	'Senior Engineer',	1,'2004-03-02', 4000.00, null),
(3, 'Maria', 'Petrova', 'Ivanova',	'Intern',	5,	'2016-08-28', 525.25, null),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO',	2,'2007-12-09', 3000.00, null),
(5, 'Peter', 'Pan', 'Pan',	'Intern',	3,'2016-08-28',	599.88, null);

#14
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

#15
SELECT * FROM `towns`
ORDER BY `name`;

SELECT * FROM `departments`
ORDER BY `name`;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

#16
SELECT `name` FROM `towns`
ORDER BY `name`;

SELECT  `name`  FROM `departments`
ORDER BY `name`;

SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;

#17
UPDATE `employees`
SET `salary`=`salary`*1.1;
SELECT `salary` FROM `employees`;

