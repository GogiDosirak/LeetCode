# Write your MySQL query statement below
SELECT name FROM SalesPerson 
WHERE name NOT IN
(SELECT s.name FROM SalesPerson s
INNER JOIN Orders o ON s.sales_id = o.sales_id
INNER JOIN Company c ON o.com_id = c.com_id
WHERE c.name = 'RED')