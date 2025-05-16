
SQL*Plus: Release 10.2.0.1.0 - Production

Copyright (c) 1982, 2005, Oracle.  All rights reserved.

사용법 1: sqlplus -H | -V

    -H		   SQL*Plus 버전과 사용법 도움말을
		   표시합니다.
    -V		   SQL*Plus 버전을 표시합니다.

사용법 2: sqlplus [ [<option>] [<logon>] [<start>] ]

  <option> : [-C <version>] [-L] [-M "<options>"] [-R <level>] [-S]

    -C <version>   영향을 받는 명령의 호환성을
		   <version>에 의해 지정된 버전으로 설정합니다.
		   해당 버전의 형식은 "x.y[.z]"입니다(예: -C 10.2.0).
    -L		   오류에 대한 메시지를 다시 표시하는 대신
		   한 번만 로그온을 시도합니다.
    -M "<options>" 출력의 자동 HTML 마크업을 설정합니다.
		   옵션의 형식은 다음과 같습니다.
		   HTML [ON|OFF] [HEAD text] [BODY text] [TABLE text]
		   [ENTMAP {ON|OFF}] [SPOOL {ON|OFF}] [PRE[FORMAT] {ON|OFF}]
    -R <level>	   제한 모드를 설정하여 파일 시스템과
		   상호 작용하는 SQL*Plus 명령을 비활성화합니다.
		   레벨은 1, 2 또는 3일 수 있습니다. 가장 제한적인 모드는 -R 3이며
		   이 모드는 파일 시스템과 상호 작용하고 있는
		   모든 사용자 명령을 비활성화합니다.
    -S		   SQL*Plus 배너의 표시, 프롬프트 및
		   명령 표시를 숨기는 자동 모드를
		   설정합니다.

  <logon>: (<username>[/<password>][@<connect_identifier>] | /)
	      [AS SYSDBA | AS SYSOPER] | /NOLOG

    데이터베이스 접속에 필요한 데이터베이스 계정 사용자 이름, 암호 및
    접속 식별자를 지정합니다. 접속 식별자를 지정하지 않으면
     SQL*Plus는 기본 데이터베이스에 접속합니다.

    AS SYSDBA 및 AS SYSOPER 옵션은 데이터베이스 관리
    권한입니다.

    /NOLOG 옵션은 데이터베이스에 접속하지 않고 SQL*Plus를
    시작합니다.

  <start>: @<URL>|<filename>[.<ext>] [<parameter> ...]

    웹 서버(URL) 또는 스크립트의 대체 변수에 지정될
    특정 매개변수를 가진 로컬 파일 시스템(filename.ext)에서
    지정된 SQL*Plus 스크립트를 실행합니다.

SQL*Plus가 시작되면 CONNECT 명령 후
사이트 프로파일(예: $ORACLE_HOME/sqlplus/admin/glogin.sql) 및
사용자 프로파일(예: 작업 디렉토리의 login.sql)이 실행됩니다.
파일에 SQL*Plus 명령이 포함되어 있을 수 있습니다.

자세한 내용은 SQL*Plus User's Guide and Reference를 참조하십시오.
