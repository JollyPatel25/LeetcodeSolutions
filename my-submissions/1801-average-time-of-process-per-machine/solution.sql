SELECT 
    machine_id,
    ROUND(
        (SUM(
            CASE 
                WHEN activity_type = 'start' THEN -timestamp
                ELSE timestamp
            END
        ) 
        / COUNT(DISTINCT process_id)::numeric
        )::NUMERIC
    , 3) AS processing_time
FROM activity
GROUP BY machine_id;

