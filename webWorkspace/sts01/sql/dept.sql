use xe;
-- dept
drop table dept;
create table dept(
	deptno int primary key,
	dname varchar(6) not null,
	loc varchar(6)
);
-- dummy data
insert into dept values (1111,'본사','서울');
insert into dept values (2222,'물류1','대전');
insert into dept values (3333,'생산','대구');
insert into dept values (4444,'물류2','부산');
commit;