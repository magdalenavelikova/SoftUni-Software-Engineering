
#1
SELECT 
    e.employee_id, e.job_title, e.address_id, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5;

#2
SELECT 
    e.first_name, e.last_name, t.name, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
        JOIN
    towns AS t ON a.town_id = t.town_id
ORDER BY e.first_name , e.last_name
LIMIT 5;

#3
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    d.name AS department_name
FROM
    employees AS e
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    d.name LIKE 'Sales'
ORDER BY employee_id DESC;

#4
SELECT 
    e.employee_id,
    e.first_name,
    e.salary,
    d.name AS department_name
FROM
    employees AS e
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    e.salary > 15000
ORDER BY d.department_id desc
LIMIT 5;

#5
SELECT 
    e.employee_id, e.first_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
WHERE
    ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

#6
SELECT 
    e.first_name, e.last_name,e.hire_date, d.name AS dept_name
FROM
    employees AS e
    LEFT JOIN    departments AS d ON e.department_id = d.department_id
WHERE
    YEAR(e.hire_date) >1998 AND d.name IN('Sales','Finance')
ORDER BY e.hire_date ;

#7
SELECT 
    e.employee_id, e.first_name, p.name AS project_name
FROM
    employees AS e
        JOIN
    employees_projects AS ep ON ep.employee_id = e.employee_id
        JOIN
    projects AS p ON ep.project_id = p.project_id
WHERE
    DATE(p.start_date) > '2002-08-13'
        AND p.end_date IS NULL
ORDER BY e.first_name , p.name
LIMIT 5;

#8
SELECT 
    e.employee_id,
    e.first_name,
    (CASE
        WHEN YEAR(p.start_date) >= 2005 THEN ' '
        ELSE p.name
    END) AS `project_name`
FROM
    employees AS e
        JOIN
    employees_projects AS ep ON ep.employee_id = e.employee_id
        JOIN
    projects AS p ON ep.project_id = p.project_id
WHERE
    e.employee_id = 24
ORDER BY project_name;

#9
SELECT 
    e.employee_id,
    e.first_name,
    e.manager_id,
    m.first_name AS manager_name
FROM
    employees AS e
        JOIN
    employees AS m ON m.employee_id = e.manager_id
WHERE
    e.manager_id IN (3 , 7)
ORDER BY e.first_name;

#10
SELECT 
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS employee_name,
    CONCAT_WS(' ', m.first_name, m.last_name) AS manager_name,
    d.name
FROM
    employees AS e
        JOIN
    employees AS m ON m.employee_id = e.manager_id
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    e.manager_id IS NOT NULL
ORDER BY e.employee_id
LIMIT 5;

#11
SELECT 
    AVG(e.salary) AS min_average_salary
FROM
    departments AS d
        JOIN
    employees AS e ON e.department_id = d.department_id
GROUP BY e.department_id
ORDER BY min_average_salary
LIMIT 1;

#12
SELECT 
    mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    peaks AS p
        JOIN
    mountains AS m ON p.mountain_id = m.id
        JOIN
    mountains_countries AS mc ON p.mountain_id = mc.mountain_id
WHERE
    p.elevation > 2835
        AND mc.country_code = 'BG'
ORDER BY p.elevation DESC;

#13
SELECT 
    mc.country_code, COUNT(m.mountain_range) AS mountain_range
FROM
    mountains AS m
        JOIN
    mountains_countries AS mc ON m.id = mc.mountain_id
WHERE
    mc.country_code IN ('BG' , 'RU', 'US')
GROUP BY mc.country_code
ORDER BY mountain_range DESC;

#14
SELECT 
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON cr.river_id = r.id
WHERE
    c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;

#15
SELECT 
    continent_code,
    currency_code,
    COUNT(country_code) AS `currency_usage`
FROM
    countries AS c
GROUP BY currency_code , continent_code
HAVING COUNT(country_code) > 1
    AND `currency_usage` = (SELECT 
        COUNT(*) AS cn
    FROM
        `countries` AS c2
    WHERE
        c2.continent_code = c.continent_code
    GROUP BY c2.currency_code
    ORDER BY cn DESC
    LIMIT 1)
ORDER BY continent_code , currency_code;