CREATE TABLE 'bbs02' (
	num INT NOT NULL,
	id VARCHAR(16) NULL DEFAULT NULL,
	nalja DateTIME NULL,
	subject VARCHAR(30) NULL DEFAULT NULL,
	content TEXT NULL,
	PRIMARY KEY (num)
)
COLLATE='utf8mb4_0990_ai_ci'
;

--
/*¡÷ºÆ*/

INSERT INTO bbs02 (id, nalja, subject, content) VALUES('tester',now(), 'test1','test')
INSERT INTO bbs02 (id, nalja, subject, content) VALUES('tester',now(), 'test2','test')
INSERT INTO bbs02 (id, nalja, subject, content) VALUES('tester',now(), 'test3','test')
commit;