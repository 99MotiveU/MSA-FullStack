drop table bbs01;
create table bbs01(
	num number primary key,
	sub varchar2(30),
	content varchar2(2000),
	writer varchar2(15),
	nalja date
);
insert into bbs01 values (1,'test1','test','tester',sysdate);
insert into bbs01 values (2,'test2','test','tester',sysdate);
insert into bbs01 values (3,'test3','test','tester',sysdate);
insert into bbs01 values ((select max(num)+1 from bbs01),'test4','test','tester',sysdate);
commit;