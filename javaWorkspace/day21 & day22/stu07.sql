create table stu07(
	num number primary key,
	name varchar2(6),
	age number(3) check(age between 1 and 100)
);