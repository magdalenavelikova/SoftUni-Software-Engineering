
#1
SELECT 
    e.employee_id,
    CONCAT_WS(' ', first_name, last_name) AS full_name,
    d.department_id,
    d.name AS department_name
FROM
    departments AS d
        LEFT JOIN
    employees AS e ON e.employee_id = d.manager_id
ORDER BY e.employee_id
LIMIT 5;

#2
SELECT 
    t.town_id, t.name, a.address_text
FROM
    addresses AS a
        LEFT JOIN
    towns AS t ON a.town_id = t.town_id
WHERE
    t.name IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY t.town_id , a.address_id;

#3
SELECT 
    employee_id, first_name, last_name, department_id, salary
FROM
    employees
WHERE
    manager_id IS NULL;

#4
SELECT 
    COUNT(employee_id)
FROM
    employees
WHERE
    salary > (SELECT 
            AVG(salary)
        FROM
            employees);