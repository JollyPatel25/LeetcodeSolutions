SELECT DISTINCT ON (product_id)
       product_id,
       NEW_PRICE AS price
FROM (
    SELECT product_id, new_price, change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    UNION ALL
    SELECT product_id, 10 AS new_price, '0001-01-01'::date AS change_date
    FROM Products
) AS p
ORDER BY product_id, change_date DESC;

