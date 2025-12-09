SELECT 
    session_id, 
    user_id, 
    EXTRACT(EPOCH FROM (MAX(event_timestamp) - MIN(event_timestamp))) / 60.0 
        AS session_duration_minutes,
    COUNT(*) FILTER (WHERE event_type = 'scroll') AS scroll_count
FROM app_events
GROUP BY session_id, user_id
HAVING 
    (
        CASE 
            WHEN COUNT(*) FILTER (WHERE event_type = 'scroll') > 0 
            THEN (COUNT(*) FILTER (WHERE event_type = 'click')::NUMERIC /
                  COUNT(*) FILTER (WHERE event_type = 'scroll')::NUMERIC)
            ELSE 0
        END
    ) < 0.20
    AND COUNT(*) FILTER (WHERE event_type = 'purchase') = 0
    AND COUNT(*) FILTER (WHERE event_type = 'scroll') > 4
    AND EXTRACT(EPOCH FROM (MAX(event_timestamp) - MIN(event_timestamp))) / 60.0 > 30
ORDER BY SCROLL_COUNT DESC, SESSION_ID ASC;
