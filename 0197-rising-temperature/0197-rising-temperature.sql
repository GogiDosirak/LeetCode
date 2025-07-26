# Write your MySQL query statement below
SELECT id
FROM (SELECT id, temperature, recordDate,
LAG(temperature) OVER(ORDER BY recordDate ASC) as prev_temp,
LAG(recordDate) OVER(ORDER BY recordDate ASC) as prev_date
FROM Weather) as a
WHERE temperature > prev_temp AND DATE_SUB(recordDate, INTERVAL 1 DAY) = prev_date