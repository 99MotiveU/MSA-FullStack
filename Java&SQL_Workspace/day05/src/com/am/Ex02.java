package com.am;

public class Ex02 {
	public static void main(String[] args) {
		System.out.print("출력");
		System.out.println("출력");
		// 변수의 사용은 반드시 선언과 초기화가 이루어져야만 사용가능 [자료형 변수명 초기화]
		int a = 1111; //변수의 선언(메모리를 어떻게 사용할지)과 초기화(메모리 최초 값의 대입)
		a=2222;
		a=(int)3.14; //강제 형변환(실수값을 int로 변환 (소수점을 다 날린다.);
		
		double b = 3.14;
		b=1.0;
		b=2; //자동 형변환(int 타입을 double 타입으로바꿔 2를 2.0으로 변환시킨다)
		
		boolean boo = true;
		boo=false;
		char ch = 'A';  // 약속패턴 메모리상 숫자, 출력 문자
		ch = 'a'+1; // ch=97+1; -> ch=98; ch='b';
		
		int x=6, y=2;
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		x++;  //x=x+1
		x--;  //x=x-1
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(boo);
		System.out.println(ch);
		func01();
		
	}
	public static void func01() {
		System.out.println("call..");
	}
}
