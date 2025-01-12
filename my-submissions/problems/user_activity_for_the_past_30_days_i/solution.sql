SELECT 
    TO_CHAR(activity_date, 'YYYY-MM-DD') AS day, 
    COUNT(DISTINCT user_id) AS active_users
FROM 
    Activity
WHERE
    activity_date BETWEEN TO_DATE('2019-06-28', 'YYYY-MM-DD') AND TO_DATE('2019-07-27', 'YYYY-MM-DD')
GROUP BY 
    TO_CHAR(activity_date, 'YYYY-MM-DD');

