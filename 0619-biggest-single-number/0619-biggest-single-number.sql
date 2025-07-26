# Write your MySQL query statement below
SELECT MAX(a.num) as num 
FROM (SELECT num FROM MyNumbers
GROUP BY num
HAVING COUNT(num) = 1) a;