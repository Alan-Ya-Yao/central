题目三：已知表A：班级，学生，课外兴趣小组（字符串：“舞蹈,画画,天文”），
将该表转化为按照每个班级，兴趣分组的学生列表
每个班级, 每种兴趣，报名的学生数

reference https://blog.csdn.net/qq_41828180/article/details/106213841

(一)需要用到LATERAL VIEW explode(split(“课外兴趣小组”,",")) intersting将课外兴趣小组成一列数据，在于原表进行笛卡尔积的叉乘，即：
select 班级，学生，intersting from A LATERAL VIEW explode(split(“课外兴趣小组”,",")) intersting ;

（二）上一步结束后，所有的兴趣与相关的班级 学生做叉乘，接下来需要用到一个listagg(学生,",") within group(order by class,intersting)函数进行姓名字符串的拼接，具体实现：

select class, 兴趣，学生列表 from（
select  class, 兴趣，concat_ws(学生, ,) as 学生列表
）from
(
    select class, student_name, 兴趣 from interests LATERAL VIEW explode(split(课外兴趣小组, ,)) as 兴趣
) b group by class, 兴趣


select class,intersting,listagg(学生,",") within group(order by class,intersting) AS stuName from (select 班级，学生，intersting from A LATERAL VIEW explode(split(“课外兴趣小组”,",")) intersting ) b group by class,intersting;
