package com.pm;

public class Ex02 {
	
	// 클래스 메서드, static method
	public static void func01() {
		System.out.println("static method");
	}

	// 멤버 메서드, 인스턴드 메서드 , non-static method
	public void func02() {
		System.out.println("멤버메서드");
		func01();
	}
	
	public void func02(int a) {
		int su = func03();
		System.out.println("su="+su);
		return;
		}
	
	public int func03() {
		return 1234;
		}
	
	public static void main(String[] args) {
		func01();
		//참조 변수
		Ex02 me =new Ex02(); //객체 생성 heap 영역
		me.func02();
		me.func03();
	}

}
