create schema Universities_DB ;
use  Universities_DB;
-- Section 1: Data Definition Language (DDL)
CREATE TABLE countries (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE
   
);

CREATE TABLE cities(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
population INT,
country_id INT NOT NULL,
CONSTRAINT `fk_cities_countries`
FOREIGN KEY (country_id)
REFERENCES `countries`(id)
);

CREATE TABLE universities(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL UNIQUE,
address VARCHAR(80) NOT NULL UNIQUE,
tuition_fee DECIMAL(19,2) NOT NULL,
number_of_staff INT,
city_id INT,
CONSTRAINT `fk_universities_cities`
FOREIGN KEY (city_id)
REFERENCES `cities`(id)
);


CREATE TABLE students(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
age INT,
phone VARCHAR(20) NOT NULL UNIQUE,
email VARCHAR(255) NOT NULL UNIQUE,
is_graduated BOOL,
city_id INT,
CONSTRAINT `fk_students_cities`
FOREIGN KEY (city_id)
REFERENCES `cities`(id)
);


CREATE TABLE courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    duration_hours DECIMAL(19 , 2 ),
    start_date DATE,
    teacher_name VARCHAR(60) NOT NULL UNIQUE,
    `description` TEXT,
    university_id INT,
    CONSTRAINT `fk_courses_universities` FOREIGN KEY (university_id)
        REFERENCES `universities` (id)
);




CREATE TABLE students_courses (
    grade DECIMAL(19 , 2 ) NOT NULL,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT `fk_students_courses_students` FOREIGN KEY (student_id)
        REFERENCES students (id),
    CONSTRAINT `fk_students_courses_courses` FOREIGN KEY (course_id)
        REFERENCES courses (id)
);



-- Section 2: Data Manipulation Language (DML)
#2
INSERT INTO courses  (`name`, duration_hours , start_date , teacher_name , `description` , university_id )
SELECT 
     CONCAT(teacher_name, ' ', 'course') ,
     CHARACTER_LENGTH(`name`)/10,
      (DATE_ADD(`start_date`, INTERVAL +5 DAY) ) ,
        reverse(teacher_name ), 
 CONCAT('Course ',teacher_name, reverse(`description`)) ,
    DAY (start_date   )
FROM
    courses
WHERE
    id <=5; 

#3
UPDATE universities 
SET 
    tuition_fee = tuition_fee + 300
WHERE
    id BETWEEN 5 AND 12;

#4
DELETE FROM universities 
WHERE
    number_of_staff IS NULL;


-- Section 3: Querying
#5
SELECT 
    *
FROM
    cities
ORDER BY population DESC;

#6
SELECT 
    first_name, last_name, age, phone, email
FROM
    students
WHERE
    age >= 21
ORDER BY first_name DESC , email , id
LIMIT 10;


#7
SELECT DISTINCT
    CONCAT_WS(' ', s.first_name, s.last_name) AS `full_name`,
    SUBSTRING(s.email, 2, 10) AS username,
    REVERSE(s.phone) AS password
FROM
    students as s
        LEFT JOIN
    students_courses AS sc ON s.id = sc.student_id
WHERE
    sc.student_id IS NULL
ORDER BY password DESC;

#8
SELECT 
     COUNT(s.id) AS students_count, u.`name` as university_name
FROM
    universities AS u
        JOIN
    courses AS c ON u.id = c.university_id
    JOIN 
    students_courses AS sc ON c.id=sc.course_id
    JOIN students AS s ON sc.student_id=s.id
GROUP BY university_name
HAVING students_count >= 8
ORDER BY students_count DESC,  university_name DESC;

#9
SELECT 
    u.`name` as university_name,
    c.`name` as city_name,
    u.`address`,
        (CASE
        WHEN u.tuition_fee < 800 THEN 'cheap'
        WHEN u.tuition_fee < 1200 THEN 'normal'
        WHEN u.tuition_fee < 2500 THEN 'high'
        ELSE 'expensive'
    END) AS `price_rank`,
   u.tuition_fee
FROM
   universities AS u
        JOIN
    cities AS c ON u.city_id = c.id
ORDER BY u.tuition_fee;

-- Section 4: Programmability 

#10



DELIMITER $$
CREATE FUNCTION `udf_average_alumni_grade_by_course_name`(course_name VARCHAR(60)) RETURNS decimal(19,2)
    DETERMINISTIC
BEGIN

RETURN (
SELECT AVG(sc.grade)
FROM students_courses as sc
JOIN students as s ON sc.student_id=s.id
JOIN courses as c ON sc.course_id=c.id
WHERE c.`name`=course_name and s.is_graduated=1

);
END$$

DELIMITER ;


SELECT 
    c.name,
    UDF_AVERAGE_ALUMNI_GRADE_BY_COURSE_NAME('Quantum Physics') AS average_alumni_grade
FROM
    courses c
WHERE
    c.name = 'Quantum Physics';



#11
SET SQL_SAFE_UPDATES = 0;

DELIMITER $$
USE `universities_db`$$
CREATE PROCEDURE `udp_graduate_all_students_by_year` (year_started INT)
BEGIN
UPDATE students as s
JOIN students_courses as sc ON s.id=sc.student_id
JOIN courses as c on sc.course_id=c.id
SET s.is_graduated=1
WHERE YEAR(c.start_date)= year_started;
END$$

DELIMITER ;

CALL udp_graduate_all_students_by_year(2017); 
