package com.am;

public class Ex02 {
	public static void main(String[] args) {
		System.out.print("���");
		System.out.println("���");
		// ������ ����� �ݵ�� ����� �ʱ�ȭ�� �̷�����߸� ��밡�� [�ڷ��� ������ �ʱ�ȭ]
		int a = 1111; //������ ����(�޸𸮸� ��� �������)�� �ʱ�ȭ(�޸� ���� ���� ����)
		a=2222;
		a=(int)3.14; //���� ����ȯ(�Ǽ����� int�� ��ȯ (�Ҽ����� �� ������.);
		
		double b = 3.14;
		b=1.0;
		b=2; //�ڵ� ����ȯ(int Ÿ���� double Ÿ�����ιٲ� 2�� 2.0���� ��ȯ��Ų��)
		
		boolean boo = true;
		boo=false;
		char ch = 'A';  // ������� �޸𸮻� ����, ��� ����
		ch = 'a'+1; // ch=97+1; -> ch=98; ch='b';
		
		int x=6, y=2;
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		x++;  //x=x+1
		x--;  //x=x-1
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(boo);
		System.out.println(ch);
		func01();
		
	}
	public static void func01() {
		System.out.println("call..");
	}
}
