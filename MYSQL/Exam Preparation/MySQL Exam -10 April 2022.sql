create schema SU_IMDb;
use  SU_IMDb;
-- Section 1: Data Definition Language (DDL)
CREATE TABLE countries (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL UNIQUE,
    `continent` VARCHAR(30) NOT NULL,
    currency VARCHAR(5) NOT NULL
);

CREATE TABLE genres(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE
);


CREATE TABLE actors(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
birthdate DATE NOT NULL,
height INT,
awards INT,
country_id INT NOT NULL,
CONSTRAINT `fk_actors_countries`
FOREIGN KEY (country_id)
REFERENCES `countries`(id)
);


CREATE TABLE movies_additional_info(
id INT PRIMARY KEY AUTO_INCREMENT,
rating DECIMAL(10,2) NOT NULL,
runtime INT NOT NULL,
picture_url VARCHAR(80) NOT NULL,
budget DECIMAL(10,2),
release_date DATE NOT NULL,
has_subtitles BOOL,
`description` TEXT
);

CREATE TABLE movies(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(70) NOT NULL UNIQUE,
country_id INT NOT NULL,
movie_info_id INT NOT NULL UNIQUE,
CONSTRAINT `fk_movies_countries`
FOREIGN KEY (country_id)
REFERENCES countries(id),
CONSTRAINT `fk_movies_movies_additional_info`
FOREIGN KEY (movie_info_id)
REFERENCES movies_additional_info(id)
);


CREATE TABLE movies_actors(
movie_id INT,
actor_id INT,
CONSTRAINT `fk_movies_actors_movies`
FOREIGN KEY (movie_id)
REFERENCES movies(id),
CONSTRAINT `fk_movies_actors_actors`
FOREIGN KEY (actor_id)
REFERENCES actors(id)
);

CREATE TABLE genres_movies(
genre_id INT,
movie_id INT,
CONSTRAINT `fk_genres_movies_genres`
FOREIGN KEY (genre_id)
REFERENCES genres(id),
CONSTRAINT `fk_genres_movies_movies`
FOREIGN KEY (movie_id)
REFERENCES movies(id)
);

-- Section 2: Data Manipulation Language (DML)
#2
INSERT INTO actors  (`first_name`, `last_name`, birthdate, height, awards, country_id)
SELECT 
    reverse(first_name),
    reverse(last_name), 
    (DATE_ADD(`birthdate`, INTERVAL -2 DAY) ) as birthdate,
    height +10,
    country_id,
    (SELECT id FROM countries WHERE name='Armenia') as country_id
FROM
    actors
WHERE
    id <=10; 

#3
UPDATE  movies_additional_info  
SET 
    runtime = runtime - 10
WHERE
    id BETWEEN 15 AND 25;

#4
DELETE c FROM countries  AS c
        LEFT JOIN
    movies AS m ON c.id = m.country_id
WHERE
    m.country_id IS NULL;


-- Section 3: Querying
#5
SELECT 
    *
FROM
    countries
ORDER BY currency DESC , id ;

#6
SELECT 
    mai.id, m.title, runtime, budget, release_date
FROM
    movies_additional_info AS mai
        LEFT JOIN
    movies AS m ON m.movie_info_id = mai.id
WHERE
    YEAR(release_date) BETWEEN 1996 AND 1999
ORDER BY mai.runtime , mai.id
LIMIT 20;


#7
SELECT DISTINCT
    CONCAT_WS(' ', first_name, last_name) AS `full_name`,
    CONCAT(REVERSE(last_name),
            CHAR_LENGTH(last_name),
            '@cast.com') AS `email `,
    (2022 - (EXTRACT(YEAR FROM birthdate))) AS age,
    height
FROM
    actors
        LEFT JOIN
    movies_actors AS ma ON id = ma.actor_id
WHERE
    ma.actor_id IS NULL
ORDER BY height;

#8
SELECT 
    c.`name`, COUNT(m.id) AS movies_count
FROM
    countries AS c
        JOIN
    movies AS m ON c.id = m.country_id
GROUP BY c.id
HAVING movies_count >= 7
ORDER BY c.`name` DESC;

#9
SELECT 
    m.title,
    (CASE
        WHEN mai.rating <= 4 THEN 'poor'
        WHEN mai.rating <= 7 THEN 'good'
        ELSE 'excellent'
    END) AS `rating `,
    (CASE
        WHEN has_subtitles = 1 THEN 'english'
        ELSE '-'
    END) AS `subtitles`,
    mai.budget
FROM
    `movies` AS m
        JOIN
    movies_additional_info AS mai ON m.movie_info_id = mai.id
ORDER BY mai.budget DESC;

-- Section 4: Programmability 

#10
DELIMITER $$
CREATE FUNCTION `udf_actor_history_movies_count`(full_name VARCHAR(50)) RETURNS int
    DETERMINISTIC
BEGIN
Declare f_name VARCHAR(40);
Declare l_name VARCHAR(40);
Declare space_index int;
SET space_index:=locate(' ',full_name);
SET f_name:= SUBSTRING(full_name,1,space_index-1);
SET l_name:=SUBSTRING(full_name,space_index+1);
RETURN (
SELECT count(ma.movie_id)
FROM actors AS a
JOIN movies_actors AS ma ON a.id=ma.actor_id
JOIN genres_movies AS gm ON ma.movie_id=gm.movie_id
JOIN genres AS g ON g.id=gm.genre_id
WHERE a.first_name=f_name AND a.last_name=l_name and g.name='History'
);
END$$

DELIMITER ;

DELIMITER ;
SELECT udf_actor_history_movies_count('Stephan Lundberg')  AS 'history_movies';
SELECT udf_actor_history_movies_count('Jared Di Batista')  AS 'history_movies';


#11
SET SQL_SAFE_UPDATES = 0;
DELIMITER $$
USE `su_imdb`$$
CREATE PROCEDURE `udp_award_movie` (movie_title VARCHAR(50))
BEGIN
UPDATE actors AS a
JOIN movies_actors as ma ON a.id=ma.actor_id
JOIN movies as m ON m.id= ma.movie_id
 SET a.awards =a.awards+1
WHERE m.title=movie_title;
END$$

DELIMITER ;


CALL udp_award_movie('Tea For Two');
