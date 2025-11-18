SELECT 
    CASE 
        WHEN salary IS NULL THEN e.employee_id 
        ELSE s.employee_id 
    END
FROM employees e
FULL OUTER JOIN salaries s
    ON e.employee_id = s.employee_id
WHERE salary IS NULL 
   OR name IS NULL
ORDER BY 
    CASE 
        WHEN salary IS NULL THEN e.employee_id 
        ELSE s.employee_id 
    END;

