package com.am;

//�߻�Ŭ����
// - �߻�޼��带 0�� �̻� ���� Ŭ����
// - ����� ���ؼ��� ������� �����ϴ� Ŭ����
abstract class Lec01{
	static int su1 = 1111;
	int su2 =2222;
	public Lec01(String msg){
		System.out.println("������ ȣ��"+msg);
	}
	protected Lec01() {}
	Lec01(int s){}
	private Lec01(double a) {}
	
	public void func01() {}
	//�߻� �޼��� - �޼����� ������ ������ ������ ���� �޼���
	public abstract void func02();;// �߻�޼��尡 ��� �߻�Ŭ���� ����
	public static void func03(){}
	//�߻��� non-static�� ���ؼ� ��� -> static�� ��� Ư�� Ŭ���� �ȿ��� ���� �� ������ �Բ� �ִٰ� �����ϸ�� : ��ü ������ ����ƽ Ű���尡 ���� ���� �����ϰ� ����
	


}

public class Ex01 extends Lec01 {
	public Ex01() {
		super("");
	}
	
	@Override
	public void func02() {//������ ���� �߻�޼��带 �������̵�
		}
	

	public static void main(String[] args) {
//		Lec01 parent = new Lec01();
		System.out.println(Lec01.su1);
		Lec01.func03();
		Ex01 me = new Ex01();
		}

}
