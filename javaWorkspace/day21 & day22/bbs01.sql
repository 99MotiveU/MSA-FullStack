create table bbs01(
	num number primary key,
	subject varchar2(21) default '제목없음',
	content varchar2(2000)
);