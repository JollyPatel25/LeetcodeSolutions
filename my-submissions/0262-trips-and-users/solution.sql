WITH UNBANNED AS 
(
    SELECT ID,
        CLIENT_ID,
        DRIVER_ID,
        CITY_ID,
        STATUS,
        REQUEST_AT
    FROM TRIPS 
    JOIN USERS CLIENT 
        ON TRIPS.CLIENT_ID = CLIENT.USERS_ID 
    JOIN USERS DRIVER 
        ON DRIVER.USERS_ID = DRIVER_ID 
    WHERE CLIENT.BANNED = 'No' 
        AND DRIVER.BANNED = 'No'
)
SELECT REQUEST_AT AS "Day", 
    ROUND(
        COALESCE(
            COUNT(*) FILTER (WHERE 
                STATUS IN ('cancelled_by_client', 'cancelled_by_driver'))
        ,0)::NUMERIC / 
        NULLIF(
            COUNT(*), 
        0), 
    2) AS "Cancellation Rate"
FROM UNBANNED
GROUP BY REQUEST_AT HAVING REQUEST_AT BETWEEN '2013-10-01' AND '2013-10-03';
