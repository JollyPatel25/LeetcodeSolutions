WITH top_performers AS (
    SELECT
        user_id
    FROM course_completions
    GROUP BY user_id
    HAVING COUNT(*) >= 5
       AND AVG(course_rating) >= 4
),

ordered_courses AS (
    SELECT
        cc.user_id,
        cc.course_name,
        cc.completion_date,
        ROW_NUMBER() OVER (
            PARTITION BY cc.user_id
            ORDER BY cc.completion_date
        ) AS rn
    FROM course_completions cc
    JOIN top_performers tp
        ON cc.user_id = tp.user_id
),

course_pairs AS (
    SELECT
        oc1.course_name AS first_course,
        oc2.course_name AS second_course
    FROM ordered_courses oc1
    JOIN ordered_courses oc2
        ON oc1.user_id = oc2.user_id
       AND oc2.rn = oc1.rn + 1
)
SELECT
    first_course,
    second_course,
    COUNT(*) AS TRANSITION_COUNT
FROM course_pairs
GROUP BY first_course, second_course
ORDER BY
    TRANSITION_COUNT DESC,
    LOWER(first_course),
    LOWER(second_course);

