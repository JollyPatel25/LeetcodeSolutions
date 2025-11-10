CREATE OR REPLACE FUNCTION NthHighestSalary(N INT)
RETURNS TABLE (Salary INT)
LANGUAGE plpgsql
AS $$
BEGIN
  RETURN QUERY
  WITH RankedEmployees AS (
    SELECT e.salary,
           DENSE_RANK() OVER (ORDER BY e.salary DESC) AS rnk
    FROM Employee e
  )
  SELECT MAX(r.salary)
  FROM RankedEmployees r
  WHERE r.rnk = N;

  IF NOT FOUND THEN
    RETURN QUERY SELECT NULL::INT;
  END IF;
END;
$$;

