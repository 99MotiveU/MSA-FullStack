package com.am;
class Ex7777{}
//�θ� Ŭ����
class Ex77{
	public void func01() {
		System.out.println("�θ��� ���");
	}
}
//�ڽ� Ŭ����
public class Ex07 extends Ex77 {//java.lang.Object 

	public static void main(String[] args) {
		// ���
		// ��� Ŭ������ �θ�Ŭ������ ��� ����
		// Ư�� ����� ������ �ֻ����� Object Ŭ������ ���
		// ���� ���
		
		Ex77 parent = new Ex77();
		Ex07 me = new Ex07();
		parent.func01();
		me.func01(); //�θ� �ִ� ���� �ڽ��� ��ӹ޾� ��� ����
//		System.out.println(me.hashCode());

	}

}
