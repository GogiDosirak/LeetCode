# Write your MySQL query statement below
SELECT u.name, SUM(t.amount) as 'BALANCE' FROM Users u
INNER JOIN Transactions t 
ON u.account = t.account
GROUP BY t.account
HAVING SUM(t.amount) > 10000