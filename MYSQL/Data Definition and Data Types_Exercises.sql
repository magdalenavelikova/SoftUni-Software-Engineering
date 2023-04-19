CREATE DATABASE `minions`;
#1
CREATE TABLE `minions` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `age` VARCHAR(50)
);

CREATE TABLE `towns` (
    `town_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
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
TRUNCATE `mimnions`;

#5
DROP TABLE `mimnions`;
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
(1,'test1', null, 180, 50,'f','13-10-2000', 'empty'),
(2,'test1', null, 180, 50,'f','13-10-2000', 'empty'),
(3,'test1', null, 180, 50,'f','13-10-2000', 'empty'),
(4,'test1', null, 180, 50,'f','13-10-2000', 'empty'),
(5,'test1', null, 180, 50,'f','13-10-2000', 'empty');

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