/* Write your PL/SQL query statement below */
select P.firstName, P.lastName, A.city, A.state from Person P Left Join Address A On P.personId = A.personID;