-- Write your PostgreSQL query statement below
SELECT * 
FROM USERS 
WHERE EMAIL ~ '^[A-Za-z0-9][A-Za-z0-9_]*@[A-Za-z]*\.com$'
order by user_id;
