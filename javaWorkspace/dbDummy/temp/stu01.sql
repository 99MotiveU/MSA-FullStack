
SQL*Plus: Release 10.2.0.1.0 - Production

Copyright (c) 1982, 2005, Oracle.  All rights reserved.

���� 1: sqlplus -H | -V

    -H		   SQL*Plus ������ ���� ������
		   ǥ���մϴ�.
    -V		   SQL*Plus ������ ǥ���մϴ�.

���� 2: sqlplus [ [<option>] [<logon>] [<start>] ]

  <option> : [-C <version>] [-L] [-M "<options>"] [-R <level>] [-S]

    -C <version>   ������ �޴� ����� ȣȯ����
		   <version>�� ���� ������ �������� �����մϴ�.
		   �ش� ������ ������ "x.y[.z]"�Դϴ�(��: -C 10.2.0).
    -L		   ������ ���� �޽����� �ٽ� ǥ���ϴ� ���
		   �� ���� �α׿��� �õ��մϴ�.
    -M "<options>" ����� �ڵ� HTML ��ũ���� �����մϴ�.
		   �ɼ��� ������ ������ �����ϴ�.
		   HTML [ON|OFF] [HEAD text] [BODY text] [TABLE text]
		   [ENTMAP {ON|OFF}] [SPOOL {ON|OFF}] [PRE[FORMAT] {ON|OFF}]
    -R <level>	   ���� ��带 �����Ͽ� ���� �ý��۰�
		   ��ȣ �ۿ��ϴ� SQL*Plus ����� ��Ȱ��ȭ�մϴ�.
		   ������ 1, 2 �Ǵ� 3�� �� �ֽ��ϴ�. ���� �������� ���� -R 3�̸�
		   �� ���� ���� �ý��۰� ��ȣ �ۿ��ϰ� �ִ�
		   ��� ����� ����� ��Ȱ��ȭ�մϴ�.
    -S		   SQL*Plus ����� ǥ��, ������Ʈ ��
		   ��� ǥ�ø� ����� �ڵ� ��带
		   �����մϴ�.

  <logon>: (<username>[/<password>][@<connect_identifier>] | /)
	      [AS SYSDBA | AS SYSOPER] | /NOLOG

    �����ͺ��̽� ���ӿ� �ʿ��� �����ͺ��̽� ���� ����� �̸�, ��ȣ ��
    ���� �ĺ��ڸ� �����մϴ�. ���� �ĺ��ڸ� �������� ������
     SQL*Plus�� �⺻ �����ͺ��̽��� �����մϴ�.

    AS SYSDBA �� AS SYSOPER �ɼ��� �����ͺ��̽� ����
    �����Դϴ�.

    /NOLOG �ɼ��� �����ͺ��̽��� �������� �ʰ� SQL*Plus��
    �����մϴ�.

  <start>: @<URL>|<filename>[.<ext>] [<parameter> ...]

    �� ����(URL) �Ǵ� ��ũ��Ʈ�� ��ü ������ ������
    Ư�� �Ű������� ���� ���� ���� �ý���(filename.ext)����
    ������ SQL*Plus ��ũ��Ʈ�� �����մϴ�.

SQL*Plus�� ���۵Ǹ� CONNECT ��� ��
����Ʈ ��������(��: $ORACLE_HOME/sqlplus/admin/glogin.sql) ��
����� ��������(��: �۾� ���丮�� login.sql)�� ����˴ϴ�.
���Ͽ� SQL*Plus ����� ���ԵǾ� ���� �� �ֽ��ϴ�.

�ڼ��� ������ SQL*Plus User's Guide and Reference�� �����Ͻʽÿ�.
