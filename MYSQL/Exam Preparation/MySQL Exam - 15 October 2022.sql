create schema restaurant;
use  restaurant;
-- Section 1: Data Definition Language (DDL)
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL UNIQUE,
    `type` VARCHAR(30) NOT NULL,
    price DECIMAL(10 , 2) NOT NULL
);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
birthdate DATE NOT NULL,
card  VARCHAR(50),
review TEXT
);

CREATE TABLE tables(
id INT PRIMARY KEY AUTO_INCREMENT,
floor INT NOT NULL,
reserved BOOL,
capacity INT NOT NULL
);

CREATE TABLE waiters(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
phone VARCHAR(50),
salary DECIMAL(10 , 2) 
);


CREATE TABLE orders(
id INT PRIMARY KEY AUTO_INCREMENT,
table_id INT NOT NULL,
waiter_id INT NOT NULL,
order_time TIME NOT NULL,
payed_status BOOL,
CONSTRAINT `fk_orders_tables`
FOREIGN KEY (table_id)
REFERENCES `tables`(id),
CONSTRAINT `fk_orders_waiters`
FOREIGN KEY (waiter_id)
REFERENCES waiters(id)
);

CREATE TABLE orders_clients(
order_id INT,
client_id INT,
CONSTRAINT `fk_orders_clients_orders`
FOREIGN KEY (order_id)
REFERENCES orders(id),
CONSTRAINT `fk_orders_clients_clients`
FOREIGN KEY (client_id)
REFERENCES clients(id)
);

CREATE TABLE orders_products(
order_id INT,
product_id INT,
CONSTRAINT `fk_orders_products_orders`
FOREIGN KEY (order_id)
REFERENCES orders(id),
CONSTRAINT `fk_orders_products_products`
FOREIGN KEY (product_id)
REFERENCES products(id)
);

-- Section 2: Data Manipulation Language (DML)
#2
INSERT INTO products (`name`, `type`, price)
SELECT 
    CONCAT(last_name, ' ', 'specialty') ,
    'Cocktail' ,
    FORMAT(CEIL(salary*0.01),2) 
FROM
    waiters
WHERE
    id > 6; 

#3
UPDATE orders 
SET 
    table_id = table_id - 1
WHERE
    id BETWEEN 12 AND 23;

#4
DELETE w FROM waiters AS w
        LEFT JOIN
    orders AS o ON w.id = o.waiter_id 
WHERE
    o.waiter_id IS NULL;


-- Section 3: Querying
#5
SELECT 
    *
FROM
    clients
ORDER BY birthdate DESC , id DESC;

#6
SELECT 
    first_name, last_name, birthdate, review
FROM
    clients
WHERE
    YEAR(birthdate) BETWEEN 1978 AND 1993 AND card IS NULL
ORDER BY last_name DESC , id ASC
LIMIT 5;


#7
SELECT 
    CONCAT(last_name,
            first_name,
            CHARACTER_LENGTH(first_name),
            'Restaurant') AS `username`,
    REVERSE(SUBSTR(email, 2, 12)) AS `password`
FROM
    waiters
WHERE
    salary IS NOT NULL
ORDER BY password DESC;

#8
SELECT 
    p.id, p.`name`, COUNT(product_id) AS count
FROM
    orders_products AS op
        JOIN
    products AS p ON p.id = op.product_id
GROUP BY product_id
HAVING count >= 5
ORDER BY count DESC , p.`name` ASC;

#9
SELECT 
    t.id AS table_id,
    t.capacity,
    COUNT(oc.client_id) AS count_clients,
    (CASE
        WHEN t.capacity = COUNT(oc.client_id) THEN 'Full'
        WHEN t.capacity > COUNT(oc.client_id) THEN 'Free seats'
        ELSE 'Extra seats'
    END) AS `availability`
FROM
    `tables` AS t
        JOIN
    orders AS o ON t.id = o.table_id
        JOIN
    orders_clients AS oc ON o.id = oc.order_id
WHERE
    t.floor = 1
GROUP BY t.id
ORDER BY t.id DESC;

-- Section 4: Programmability 

#10
DELIMITER $$

CREATE FUNCTION `udf_client_bill`(full_name VARCHAR(50)) RETURNS decimal(19,2)
    DETERMINISTIC
BEGIN
Declare f_name VARCHAR(40);
Declare l_name VARCHAR(40);
Declare space_index int;
SET space_index:=locate(' ',full_name);
SET f_name:= SUBSTRING(full_name,1,space_index-1);
SET l_name:=SUBSTRING(full_name,space_index+1);

RETURN(
SELECT sum(p.price)
FROM clients AS c
JOIN orders_clients AS oc ON c.id=oc.client_id
JOIN orders_products AS op ON oc.order_id=op.order_id
JOIN products AS p ON op.product_id=p.id
WHERE c.first_name=f_name AND c.last_name=l_name
);
END$$

DELIMITER ;
SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';

#11
SET SQL_SAFE_UPDATES = 0;
DELIMITER $$
CREATE PROCEDURE `udp_happy_hour`(type VARCHAR(50))
BEGIN
UPDATE products AS p SET p.price = p.price*0.8
WHERE p.price>=10.00;
END$$
DELIMITER ;

CALL udp_happy_hour ('Cognac');
