# Write your MySQL query statement below
SELECT customer_number
FROM 
(SELECT customer_number,
RANK() OVER(ORDER BY count(*) DESC) as rk
FROM Orders
GROUP BY customer_number) as a
WHERE rk = 1;
