package com.my.module;

import java.util.Properties;

import org.apache.log4j.Logger;

public class Module07 implements MyModule {
	Logger logger=Logger.getLogger(getClass());
	Properties props;
	
	public void setProps(Properties props) {
		this.props = props;
	}

	@Override
	public void func01() {
		// DEBUG < INFO < WARN < ERROR < FATAL.
		logger.debug(props);
		logger.info(props);
		logger.warn(props);
		logger.error(props);
		logger.fatal(props);
	}
//	Log4j PatternLayout class
//	%p debug, info, warn, error, fatal ���� priority �� ��µȴ�.
//	%m �α׳����� ��µ˴ϴ�
//	%d �α� �̺�Ʈ�� �߻��� �ð��� ����մϴ�. ������ %d{HH:mm:ss, SSS}, %d{yyyy MMM dd HH:mm:ss, SSS}���� ���·� ����ϸ� SimpleDateFormat�� ���� �������� �ϸ� �ȴ�
//	%d{ABSOLUTE}
//	%d{DATE}
//	%d{ISO8601}
//	%t �α��̺�Ʈ�� �߻��� �������� �̸��� ����մϴ�.
//	%% % ǥ�ø� ����ϱ� ���� ����Ѵ�.
//	%n �÷��� �������� ���๮�ڰ� ��µȴ�. rn �Ǵ� n �ϰ��̴�.
//	%c ī�װ��� ǥ���մϴ� ��) ī�װ��� a.b.c ó�� �Ǿ��ִٸ� %c{2}�� b.c�� ��µ˴ϴ�.
//	%C Ŭ�������� �����մϴ�. ��)Ŭ���������� org.apache.xyz.SomeClass ó�� �Ǿ��ִٸ� %C{2}�� xyz.SomeClass �� ��µ˴ϴ�
//	%F �α��� �߻��� ���α׷� ���ϸ��� ��Ÿ���ϴ�.
//	%l �α��� �߻��� caller�� ������ ��Ÿ���ϴ�
//	%L �α��� �߻��� caller�� ���μ��� ��Ÿ���ϴ�
//	%M �α��� �߻��� method �̸��� ��Ÿ���ϴ�.
//	%r ���ø����̼� ���� ���� ���� �α��� �߻��� ������ �ð�(milliseconds)
//	%x �α��� �߻��� thread�� ���õ� NDC(nested diagnostic context)�� ����մϴ�.
//	%X �α��� �߻��� thread�� ���õ� MDC(mapped diagnostic context)�� ����մϴ�. %X{key} ����.
}






