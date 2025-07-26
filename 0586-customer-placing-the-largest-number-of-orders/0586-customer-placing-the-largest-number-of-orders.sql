# Write your MySQL query statement below
SELECT
  customer_number
FROM (
    SELECT
      customer_number,
      RANK() OVER (ORDER BY order_counts DESC) AS rnk
    FROM (
        SELECT
          customer_number,
          COUNT(*) AS order_counts
        FROM Orders
        GROUP BY customer_number
      ) AS a
) AS b
WHERE rnk = 1;

