package com.am;

public class Ex01 {
	
	//public Ex01() {}  ����Ʈ ������
	//public Ex01(String msg) {System.out.println(msg);} �Ű������� �ϳ��� ���� ����Ʈ �����ڴ� �������.
	public Ex01() {
//		System.out.println("��ü�� �����Ǵ� ������");
//		System.out.println("��ü ����");
//		System.out.print("�Ű����� ����");
//		System.out.println("��ü ���� ����"); this()�� ������ �� ��ܿ� ��ġ
		this("����");
		System.out.println("���� �� ����"); 
		System.out.println(this);//�������� ȣ�� this()�ʹ� �ٸ�����
	}
	public Ex01(int su) {
//		System.out.println("��ü ����");
//		System.out.print("�Ű����� ");
//		System.out.println("���� : "+su);
//		System.out.println("��ü ���� ����"); this()�� ������ �� ��ܿ� ��ġ
		this("���� : " + su);
		System.out.println("���� �� ����");
	}
	public Ex01(String msg) {
		System.out.println("��ü�� �����Ǵ� ������");
		System.out.println("��ü ����");
		System.out.print("�Ű����� ");
		System.out.println("���ڿ� : "+msg);
//		this(); �����ڵ��� �ϳ��� this()�̿��� ȣ���� ���°� ���� �ؾ��Ѵ�.
	}
	Ex01 me2;  //Ex01 me2 = null;
	public static String msg; // =null, ��ü ��ü�� ����, �ּҰ� ����
	public static String msg2=""; //��ü�� �ִµ� item(����)�� ����
	
	public static void main(String[] args) {
		Ex01 me = new Ex01();
		Ex01 me1 = new Ex01("Hello"); //���� ���� (Ŭ���� Ÿ��)�� ����Ʈ���� null
		char ch = '\u0000'; //���� null
		Ex01 me2 =null; // Ű���� ���� null
		me=new Ex01("�����ڵ� 0=> "+ch); 
		me=new Ex01("�����ڵ� 0=> "+me2); 
		me=new Ex01(msg);
		//msg.length(); 
		msg2.length();
		me = new Ex01(123);
		me=new Ex01("���ڿ�");
	
	}

}
