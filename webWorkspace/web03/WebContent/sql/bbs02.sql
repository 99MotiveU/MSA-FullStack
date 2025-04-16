drop table bbs02;
drop sequence bbs02_seq;
--
CREATE TABLE BBS02 
(
  NUM NUMBER NOT NULL 
, ID VARCHAR2(16) NOT NULL 
, NALJA DATE DEFAULT sysdate 
, SUBJECT VARCHAR2(30) NOT NULL 
, CONTENT VARCHAR2(2000) 
, CONSTRAINT BBS02_PK PRIMARY KEY 
  (
    NUM 
  )
  ENABLE 
);
--
create sequence bbs02_seq;
-- dummy
insert into bbs02 values (bbs02_seq.nextval,'tester',sysdate,'test1','test');
insert into bbs02 values (bbs02_seq.nextval,'tester',sysdate,'test2','test');
insert into bbs02 values (bbs02_seq.nextval,'tester',sysdate,'test3','test');
insert into bbs02 values (bbs02_seq.nextval,'tester',sysdate,'test4','test');
commit;
