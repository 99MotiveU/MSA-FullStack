package com.am;

public class Ex01 {
	public static final int a=2222;
	public static int b=2222;  //전역변수
	//전역변수와 메서드 클래스 등은 최대한  main이전에 기입 오버로드 같은것도 묶고 같이 최대한 가까이 두기
	public int c;
	public static void func01() {
		System.out.println(b);
		b++;
		//a++;
	}
	public static void func02(final int c) {
		//c++;
		System.out.println("c="+c);
	}
	
	public Ex01() {
		//default 생성자
		//코드상 클래스에 생성자가 없을 경우 컴파일러는 default 생성자를 자동생성
		c=1234;
	}
	public Ex01(int a) {
		//생성자 또한 매개변수의 타입 유무 등으로 여러개 생성가능
		//return은 있지만 값은 없다.
		c=a;
		return;
	}
	
	//public int a =3333; 전역변수 끼리 같을 수 없고 지역변수 끼리 같을 수 없다. + final함수 이다.
	public static void main(String[] args) {
		int a=1111;
		System.out.println("a="+a);
		System.out.println("com.am.a="+com.am.Ex01.a);
		//final int a=2222;   //final로 인해 값을 바꿀 수 없다 / 지역변수 -final 상수형 변수
		//System.out.println("a="+a);
		Ex01 me; 
		me= new Ex01(3);
		System.out.println("c= "+me.c);
		
		func02(3333);
		func02(4444); //이렇게는 가능
		

	}

}
