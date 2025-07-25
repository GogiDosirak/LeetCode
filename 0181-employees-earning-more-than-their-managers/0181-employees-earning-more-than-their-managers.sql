# Write your MySQL query statement below
SELECT a.name as Employee
FROM Employee a
INNER JOIN Employee b on a.managerId = b.id
WHERE a.salary > b.salary
