package com.am;

public class Ex01 {
	public static final int a=2222;
	public static int b=2222;  //��������
	//���������� �޼��� Ŭ���� ���� �ִ���  main������ ���� �����ε� �����͵� ���� ���� �ִ��� ������ �α�
	public int c;
	public static void func01() {
		System.out.println(b);
		b++;
		//a++;
	}
	public static void func02(final int c) {
		//c++;
		System.out.println("c="+c);
	}
	
	public Ex01() {
		//default ������
		//�ڵ�� Ŭ������ �����ڰ� ���� ��� �����Ϸ��� default �����ڸ� �ڵ�����
		c=1234;
	}
	public Ex01(int a) {
		//������ ���� �Ű������� Ÿ�� ���� ������ ������ ��������
		//return�� ������ ���� ����.
		c=a;
		return;
	}
	
	//public int a =3333; �������� ���� ���� �� ���� �������� ���� ���� �� ����. + final�Լ� �̴�.
	public static void main(String[] args) {
		int a=1111;
		System.out.println("a="+a);
		System.out.println("com.am.a="+com.am.Ex01.a);
		//final int a=2222;   //final�� ���� ���� �ٲ� �� ���� / �������� -final ����� ����
		//System.out.println("a="+a);
		Ex01 me; 
		me= new Ex01(3);
		System.out.println("c= "+me.c);
		
		func02(3333);
		func02(4444); //�̷��Դ� ����
		

	}

}
