package com.am;

abstract class Machine{
	public void on() {
		System.out.println("�Ѵ�");
	}
	public void off() {
		System.out.println("����");
	}
	//1. ����� ���ؼ��� ����ϵ��� ����
	public abstract void work();
//	public void wark() {};
}
//2. Ư���޼����� �������̵带 ���� / ��ɾ� ����
class Audio extends Machine{
	@Override
	public void work() {
		System.out.println();
	}
}

class Tv extends Machine{
	@Override
	public void work() {
		System.out.println("ȭ���� �����ش�");
	}
}
class Radio extends Machine{
	@Override
	public void work() {
		System.out.println("�Ҹ��� ����ִ�");
	}
}


public class Ex02 {

	public static void main(String[] args) {
		Machine remote = new Tv();
		remote.on();
		remote.work();
		remote.off();

	}

}
