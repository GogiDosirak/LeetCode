# Write your MySQL query statement below
SELECT name as Customers From Customers
WHERE id NOT IN (SELECT c.id as Customers From Customers c
INNER JOIN Orders o ON c.id = o.customerId)