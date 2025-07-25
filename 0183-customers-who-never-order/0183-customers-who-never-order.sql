# Write your MySQL query statement below
SELECT c.name as Customers From Customers c
LEFT OUTER JOIN Orders o ON c.id = o.customerId
WHERE o.id IS NULL