Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary.
 If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

select s1.Salary as SecondHighestSalary from Salary s1
where  2 (select count( distinct s2.Salary) from Salary s2 where )


## two select loop

select s1.Salary as SecondHighestSalary from Employee s1 where 1 > (select count(distinct s2.Salary) from Employee s2 where s2.Salary > s1.Salary)