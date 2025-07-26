# Write your MySQL query statement below
SELECT machine_id, ROUND((SUM(CASE WHEN activity_type = 'end' THEN timestamp END) - SUM(CASE WHEN activity_type = 'start' THEN timestamp END))/(COUNT(*)/2),3) as processing_time
FROM Activity
GROUP BY machine_id