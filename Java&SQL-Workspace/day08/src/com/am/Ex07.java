package com.am;
class Ex7777{}
//부모 클래스
class Ex77{
	public void func01() {
		System.out.println("부모의 기능");
	}
}
//자식 클래스
public class Ex07 extends Ex77 {//java.lang.Object 

	public static void main(String[] args) {
		// 상속
		// 모든 클래스는 부모클래스는 상속 받음
		// 특별 상속이 없으면 최상위의 Object 클래스를 상속
		// 단일 상속
		
		Ex77 parent = new Ex77();
		Ex07 me = new Ex07();
		parent.func01();
		me.func01(); //부모에 있는 것을 자식이 상속받아 사용 가능
//		System.out.println(me.hashCode());

	}

}
