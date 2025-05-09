package com.am;

public class Ex02 {
	
	public Ex02() {
		System.out.println("객체 생성");
		this.func01(); //this는 생략 가능(표기 안해도 알아서 들어감)
		//생성자에서는 반드시 this를 사용할 수 밖에 없음
	}
	public Ex02(Ex02 me) {
		me.func01();
	}
	
	public static void main(String[] args) {
		Ex02 me =new Ex02();
	}
	
	public void func01() {
		System.out.println("기능 호출");
	}

	public void func02(Ex02 me) {
		me.func01();
	}
}
