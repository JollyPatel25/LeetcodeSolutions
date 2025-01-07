/* Write your PL/SQL query statement below */
select e.name Employee from Employee e, employee manager where e.salary > manager.salary and e.managerId = manager.id;