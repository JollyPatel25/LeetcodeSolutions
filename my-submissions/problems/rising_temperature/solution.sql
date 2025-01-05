/* Write your PL/SQL query statement below */
SELECT w.id 
FROM weather w, weather t 
WHERE w.recordDate = (TO_DATE(t.recordDate, 'YYYY-MM-DD') + 1) AND w.temperature > t.temperature;