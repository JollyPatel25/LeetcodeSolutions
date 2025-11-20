WITH first_login AS (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
),
next_day_login AS (
    SELECT f.player_id
    FROM first_login f
    JOIN Activity a
      ON f.player_id = a.player_id
     AND a.event_date = f.first_date + INTERVAL '1 day'
)
SELECT 
    ROUND(
        (SELECT COUNT(*) FROM next_day_login)::numeric 
        / 
        (SELECT COUNT(*) FROM first_login),
        2
    ) AS fraction;

