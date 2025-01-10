/* Write your PL/SQL query statement below */
SELECT p.product_name, year, price 
FROM sales s 
JOIN product p 
ON p.product_id = s.product_id;