/* Write your PL/SQL query statement below */
UPDATE SALARY  
SET sex = 
    CASE WHEN SEX = 'f' THEN 'm'
    ELSE 'f'
    END
;