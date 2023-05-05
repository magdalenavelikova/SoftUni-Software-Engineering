DELIMITER $$
#1
CREATE PROCEDURE `usp_get_employees_salary_above_35000` ()
BEGIN
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    salary > 35000
ORDER BY first_name , last_name , employee_id;
END$$

#2
CREATE PROCEDURE `usp_get_employees_salary_above` (`salary_param` DECIMAL(10,4))
BEGIN
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    salary >= salary_param
ORDER BY first_name , last_name , employee_id;
END$$

#3
CREATE PROCEDURE `usp_get_towns_starting_with`(`string_param` VARCHAR(20))
BEGIN
SELECT `name` FROM towns
WHERE `name` LIKE concat(`string_param`,'%')
ORDER BY `name`;
END$$

call  usp_get_towns_starting_with('d')$$

#4
CREATE PROCEDURE `usp_get_employees_from_town` (town_name VARCHAR(40))
BEGIN
SELECT 
    first_name, last_name
FROM
    employees
        JOIN
    addresses USING (address_id)
        JOIN
    towns AS t USING (town_id)
WHERE
    t.`name` = town_name
    ORDER BY first_name , last_name , employee_id;
END$$

#5
CREATE FUNCTION `ufn_get_salary_level` (salary DOUBLE(10,2))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN

RETURN (CASE
        WHEN salary < 30000 THEN 'Low'
        WHEN salary  <= 50000 THEN 'Average'
        ELSE 'High'
    END);
END$$

#6
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`salary_level` VARCHAR(10))
BEGIN
SELECT 
   `first_name`, `last_name`
   FROM
    employees
   WHERE (salary_level='Low'  AND  salary < 30000) OR
    (salary_level='Average' AND (salary >= 30000 AND salary <= 50000))
       OR ( salary_level='High'  AND salary >= 50000)
       ORDER BY `first_name` DESC, `last_name` DESC ;
END$$
call usp_get_employees_by_salary_level('Average')$$

-- other solution --
CREATE FUNCTION `ufn_get_salary_level` (salary DOUBLE(10,2))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN

RETURN (CASE
        WHEN salary < 30000 THEN 'Low'
        WHEN salary  <= 50000 THEN 'Average'
        ELSE 'High'
    END);
END;
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`salary_level` VARCHAR(10))
BEGIN
SELECT 
   `first_name`, `last_name`
   FROM
    employees
   WHERE (SELECT ufn_get_salary_level(`salary`)=`salary_level`)
       ORDER BY `first_name` DESC, `last_name` DESC ;
END$$

#7
CREATE FUNCTION `ufn_is_word_comprised`(set_of_letters varchar(50), word varchar(50)) RETURNS bit(1)
    DETERMINISTIC
RETURN word REGEXP (concat('^[', set_of_letters, ']+$'))$$

#8
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_get_holders_full_name`()
BEGIN
SELECT 
    CONCAT(first_name, ' ', last_name) AS full_name
FROM
    account_holders
ORDER BY full_name, id;
END$$

#9
CREATE  PROCEDURE `usp_get_holders_with_balance_higher_than`(salary_param INT)
BEGIN
  SELECT 
     ah.first_name, ah.last_name
FROM
    accounts AS a
    JOIN 
    account_holders AS ah
    ON a.account_holder_id = ah.id
GROUP BY a.account_holder_id
HAVING SUM(a.balance) > salary_param
ORDER BY ah.id;
END$$

#10
CREATE FUNCTION `ufn_calculate_future_value`(initial_sum DECIMAL(19, 4), interest_rate DECIMAL(19, 4), years INT) RETURNS DECIMAL(19,4)
    DETERMINISTIC
BEGIN
    RETURN initial_sum * POW((1 + interest_rate), years);
END$$

SELECT UFN_CALCULATE_FUTURE_VALUE(1000, 0.5, 5);


#11
CREATE FUNCTION `ufn_calculate_future_value`(initial_sum DECIMAL(19, 4), interest_rate DECIMAL(19, 4), years INT) RETURNS DECIMAL(19,4)
    DETERMINISTIC
BEGIN
    RETURN initial_sum * POW((1 + interest_rate), years);
END;


CREATE PROCEDURE `usp_calculate_future_value_for_account`(id_param INT, interest_rate DECIMAL(19,4) )
BEGIN
SELECT 
     a.id, ah.first_name, ah.last_name, a.balance AS current_balance,
     (SELECT ufn_calculate_future_value( a.balance,interest_rate, 5) ) AS balance_in_5_years
FROM
account_holders AS ah
      JOIN 
       accounts AS a
    ON a.account_holder_id = ah.id
    WHERE a.id=id_param;
END$$

#12
CREATE PROCEDURE `usp_deposit_money`(account_id INT, money_amount DECIMAL(10,4))
BEGIN
IF money_amount>0 THEN
Start TRANSACTION;
UPDATE accounts 
SET 
    balance = balance + money_amount
WHERE
    account_id = id;

IF EXISTS(SELECT id FROM accounts WHERE account_id=id ) THEN
COMMIT;
ELSE
ROLLBACK;
END IF;
END IF;
END$$

#13
CREATE  PROCEDURE `usp_withdraw_money`(account_id INT, money_amount DECIMAL(19,4))
BEGIN
IF money_amount>0 AND (SELECT balance FROM accounts WHERE account_id=id)>= money_amount THEN
Start TRANSACTION;
UPDATE accounts 
SET 
    balance = balance - money_amount
WHERE
    account_id = id;

IF EXISTS(SELECT id FROM accounts WHERE account_id=id ) 
 THEN
COMMIT;
ELSE
ROLLBACK;
END IF;
END IF;
END$$



#14
CREATE PROCEDURE `usp_transfer_money`(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
IF amount > 0 AND 
EXISTS (SELECT id  FROM accounts  WHERE id=from_account_id) AND
EXISTS (SELECT id  FROM accounts  WHERE id=to_account_id) AND
from_account_id<>to_account_id AND
(SELECT balance  FROM accounts  WHERE id=from_account_id)>=amount
THEN
START TRANSACTION;

UPDATE accounts 
SET 
    balance = balance - amount
WHERE
    id = from_account_id;

UPDATE accounts 
SET 
    balance = balance + amount
WHERE
    id = to_account_id;
COMMIT;
ELSE
ROLLBACK;
END IF;
END$$

#15
CREATE TABLE `logs`
(log_id INT PRIMARY KEY AUTO_INCREMENT, 
account_id INT NOT NULL,
 old_sum DECIMAL(19,4), 
 new_sum DECIMAL(19,4))$$
 
CREATE TRIGGER `accounts_AFTER_UPDATE` AFTER UPDATE ON `accounts` FOR EACH ROW
BEGIN
INSERT INTO `logs`(account_id, old_sum, new_sum)
VALUES(old.id,old.balance,new.balance);
END$$

#16

CREATE TABLE `logs`
(log_id INT PRIMARY KEY AUTO_INCREMENT, 
account_id INT NOT NULL,
 old_sum DECIMAL(19,4), 
 new_sum DECIMAL(19,4));
 
CREATE TRIGGER `accounts_AFTER_UPDATE` AFTER UPDATE ON `accounts` FOR EACH ROW
BEGIN
INSERT INTO `logs`(account_id, old_sum, new_sum)
VALUES(old.id,old.balance,new.balance);
END;

 
CREATE TABLE `notification_emails` (
id INT PRIMARY KEY AUTO_INCREMENT, 
recipient INT NOT NULL,
 `subject` VARCHAR(100), 
 body VARCHAR(255));


CREATE TRIGGER `logs_AFTER_INSERT` BEFORE INSERT ON `logs` FOR EACH ROW BEGIN
INSERT INTO `notification_emails`( `recipient`, `subject`, `body`)
VALUES( new.account_id,
concat( 'Balance change for account: ',new.account_id),
CONCAT('On ', NOW(), ' your balance was changed from ', ROUND(NEW.old_sum, 0), ' to ', ROUND(NEW.new_sum, 0), '.')
);
END