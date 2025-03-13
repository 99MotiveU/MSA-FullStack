package com.am;

class Ex100 {
	int su = 111;

	public Ex100(String msg) {

	}

	public void func01() {
		System.out.println("부모 기능");
	}
}

public class Ex10 extends Ex100 {
	int su = 222;

	public Ex10() {
		super("aaa");
	} // 부모 클래스의 생성자 호출

	public Ex10(int a) {
		this();
	}

	public void func01() {
//		super.func01();   부모 기능 쓰기
		System.out.println("자식 기능" + this.su); //this는 생략되어 있음 / 자식 클래스에  222가 없으면 부모껄 가져온다! this를 써도 되지만 super가 맞는것
		System.out.println("자식 기능" + super.su);
	}

	public static void main(String[] args) {
		Ex10 me = new Ex10();
		me.func01();
	}

}
