/* Write your PL/SQL query statement below */
select customer_number 
from orders 
group by 
customer_number 
having count(*) = (select max(count(*)) from orders group by customer_number);