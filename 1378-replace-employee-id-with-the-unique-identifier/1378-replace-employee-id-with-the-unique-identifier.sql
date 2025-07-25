# Write your MySQL query statement below
SELECT u.unique_id, e.name 
FROM Employees e
LEFT OUTER JOIN EmployeeUNI u on e.id = u.id