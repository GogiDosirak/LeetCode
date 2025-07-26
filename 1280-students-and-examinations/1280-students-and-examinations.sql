# Write your MySQL query statement below
SELECT a.student_id, a.student_name, b.subject_name, (SELECT COUNT(*) FROM Examinations e WHERE a.student_id = e.student_id AND b.subject_name = e.subject_name) as attended_exams
FROM students a, subjects b
ORDER BY student_id, subject_name