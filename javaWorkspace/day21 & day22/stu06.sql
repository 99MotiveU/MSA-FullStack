create table stu06(
	num number primary key,
	name varchar2(6),
	gender char(1) check(gender in ('m','f'))
);