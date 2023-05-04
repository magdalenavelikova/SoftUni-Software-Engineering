#1
DELIMITER $$
CREATE FUNCTION `ufn_count_employees_by_town`(town_name VARCHAR(40))
RETURNS INTEGER
DETERMINISTIC
BEGIN

RETURN (SELECT 
    COUNT(*)
FROM
    employees AS e
        JOIN
    addresses AS a USING (address_id)
        JOIN
    towns AS t USING (town_id)
WHERE
    t.name = town_name);
END$$

DELIMITER ;

select `ufn_count_employees_by_town`('Sofia');

#2
DELIMITER $$
CREATE  PROCEDURE `usp_raise_salaries`(`department_name` VARCHAR(40))
BEGIN
UPDATE `employees`
        JOIN
    departments AS d USING (department_id) 
SET 
    `salary` = `salary` * 1.05
WHERE
    d.`name` = `department_name`;
END$$
DELIMITER ;

call usp_raise_salaries('Finance');

#3
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
START TRANSACTION;
	IF((SELECT count(employee_id) FROM employees WHERE employee_id like id)<>1) THEN
	ROLLBACK;
	ELSE
		UPDATE employees AS e SET salary = salary + salary*0.05 
		WHERE e.employee_id = id;
	END IF; 
END$$
DELIMITER ;

call usp_raise_salary_by_id(15932);

#4
CREATE TABLE IF NOT EXISTS `deleted_employees` (
  `employee_id` int(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `job_title` varchar(50) NOT NULL,
  `department_id` int(10) NOT NULL,
  `salary` decimal(19,4) NOT NULL,
   PRIMARY KEY (`employee_id`)
  );
  
  -- Triger--
DELIMITER $$
CREATE TRIGGER `employees_BEFORE_DELETE` BEFORE DELETE ON `employees` FOR EACH ROW
BEGIN
INSERT INTO `deleted_employees` (first_name,last_name,middle_name,job_title,department_id,salary)
	VALUES(OLD.first_name,OLD.last_name,OLD.middle_name, OLD.job_title,OLD.department_id,OLD.salary);
END$$
DELIMITER ;