WITH ranked AS (
  SELECT
    student_id,
    subject,
    score,
    exam_date::date AS d,
    ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date::date)    AS rn_first,
    ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date::date DESC) AS rn_last,
    COUNT(*)     OVER (PARTITION BY student_id, subject)                             AS cnt
  FROM Scores
)
SELECT
  student_id,
  subject,
  MAX(CASE WHEN rn_first = 1 THEN score END) AS first_score,
  MAX(CASE WHEN rn_last  = 1 THEN score END) AS latest_score
FROM ranked
WHERE cnt > 1
GROUP BY student_id, subject
HAVING MIN(CASE WHEN rn_last = 1 THEN score END) > MIN(CASE WHEN rn_first = 1 THEN score END)
ORDER BY student_id, subject;

