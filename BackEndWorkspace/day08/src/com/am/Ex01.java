package com.am;

public class Ex01 {
	public static int su1 = 1111;
	static int su2 = 2222;
	private static int su3 = 3333;

	public static void func01() {
	}

	static void func02() {
	}

	private static void func03() {
	}

	public static void main(String[] args) {
		com.am.Ex01.func01();
		com.am.Ex01.func02();
		com.am.Ex01.func03();
		System.out.println(com.am.Ex01.su1);
		System.out.println(com.am.Ex01.su2);
		System.out.println(com.am.Ex01.su3);

		System.out.println(com.am.Ex03.su3);
		System.out.println(com.am.Ex03.su4);

		com.am.Ex04 ex04;
		ex04 = new com.am.Ex04(1111);
//		ex04 = new com.am.Ex4(true);
//		ex04 = new.am.Ex04("");
		System.out.println();
		
//		Ex06 ex06 = Ex06.obj();
	}
}
