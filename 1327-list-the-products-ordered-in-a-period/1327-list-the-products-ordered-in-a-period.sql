# Write your MySQL query statement below
SELECT p.product_name, o.unit 
FROM Products p
INNER JOIN (SELECT product_id, sum(unit) as unit FROM Orders
WHERE DATE_FORMAT(order_date,'%Y-%m') = '2020-02'
GROUP BY product_id
HAVING SUM(unit) >= 100
) o 
ON p.product_id = o.product_id