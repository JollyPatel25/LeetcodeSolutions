WITH tab1 AS (
    SELECT 
        mr.movie_id,
        m.title,
        mr.user_id,
        u.name,
        mr.rating,
        mr.created_at::date AS rated_on
    FROM movierating mr
    JOIN movies m ON m.movie_id = mr.movie_id
    JOIN users u  ON u.user_id = mr.user_id
),

top_user AS (
    SELECT 
        name AS results
    FROM tab1
    GROUP BY user_id, name
    ORDER BY COUNT(*) DESC, name
    LIMIT 1
),

top_movie AS (
    SELECT 
        title AS results
    FROM tab1
    WHERE rated_on >= '2020-02-01'
      AND rated_on <  '2020-03-01'
    GROUP BY movie_id, title
    ORDER BY AVG(rating) DESC, title
    LIMIT 1
)

SELECT * FROM top_user
UNION ALL
SELECT * FROM top_movie;

