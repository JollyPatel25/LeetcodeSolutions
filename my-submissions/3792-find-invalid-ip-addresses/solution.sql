WITH parts AS (
    SELECT 
        ip,
        string_to_array(ip, '.') AS arr
    FROM logs
),
invalid AS (
    SELECT 
        ip,
        (
            CASE WHEN array_length(arr, 1) != 4 THEN 1 ELSE 0 END +
            (
                SELECT COUNT(*) 
                FROM unnest(arr) AS o
                WHERE length(o) > 1 AND o LIKE '0%' 
            ) +
            (
                SELECT COUNT(*) 
                FROM unnest(arr) AS o
                WHERE o !~ '^[0-9]+$' OR o::int > 255
            )
        ) AS invalid_count
    FROM parts
)
SELECT IP, COUNT(*) AS INVALID_COUNT
FROM invalid
WHERE invalid_count > 0
GROUP BY IP
ORDER BY invalid_count DESC, ip DESC;

