package com.pm;

public class Ex08 {

	public static void main(String[] args) {
		System.out.println(com.am.Ex07.func02()); 
		System.out.println(func02());  //com.pm.Ex08.func02()
			//��Ű���� ���� ��ġ ���� -�����Ȱ���
		com.pm.Ex08 me = new Ex08();
		System.out.println(me.func03());
		me.func04(me);
	}
	public static String func02() {
		return "�� �ƴ�����~~~";
	}
	
	public String func03() {
		return "non-static";
	}
	
	public void func04(Ex08 me) {
		System.out.println("�Ʒ��� func04 ȣ��");
		System.out.println(me.func03());
		System.out.println(this.func03());
		System.out.println(me==this);
		//���� ��ü�� ����� �翬�� �ٸ���.
		com.pm.Ex08 me1 = new Ex08();
		System.out.println(me1==this); //���۷��� �� (�ּҰ� ��)
		//if���۷��� �񱳸� �ؼ� ������ ���� ��ü�� ����Ű�� �ִ°�
	}
		
}
