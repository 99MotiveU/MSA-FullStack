package com.am;

public class Ex02 {
	
	public Ex02() {
		System.out.println("��ü ����");
		this.func01(); //this�� ���� ����(ǥ�� ���ص� �˾Ƽ� ��)
		//�����ڿ����� �ݵ�� this�� ����� �� �ۿ� ����
	}
	public Ex02(Ex02 me) {
		me.func01();
	}
	
	public static void main(String[] args) {
		Ex02 me =new Ex02();
	}
	
	public void func01() {
		System.out.println("��� ȣ��");
	}

	public void func02(Ex02 me) {
		me.func01();
	}
}
