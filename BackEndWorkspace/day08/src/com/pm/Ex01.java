package com.pm;

public class Ex01 {

	public static void main(String[] args) {
		com.am.Ex01.func01();
//		com.am.Ex01.func02();	default로 동일 패키지 내에서만 접근을 허용함
//		com.am.Ex01.func03();	private 
		System.out.println(com.am.Ex01.su1);
//		System.out.println(com.am.Ex01.su2);	default로 동일 패키지 내에서만 접근을 허용함
//		System.out.println(com.am.Ex01.su3);	private

		System.out.println(com.am.Ex03.su3);
//		System.out.println(com.am.Ex04.su4);
	}

}
