# Write your MySQL query statement below
SELECT employee_id, name, (SELECT COUNT(*) FROM Employees WHERE reports_to = a.employee_id) as reports_count , 
ROUND((SELECT AVG(age) FROM Employees WHERE reports_to = a.employee_id GROUP BY reports_to),0) as average_age
FROM Employees a
WHERE employee_id IN (SELECT reports_to FROM Employees) 
ORDER BY employee_id
