package com.pm;

public class Ex10 {
//	public static int su1=1111;
	public int su2 = 2222;

	public static void main(String[] args) {
//		int su1=1111;
//		System.out.println("main su1="+su1);
//		func01(su1);
//		System.out.println("main su1="+su1);
		Ex10 me = new Ex10();
		System.out.println("main su2 = " + me.su2);
		me.func02();
		Ex10 me2 = new Ex10();
		System.out.println("main su2 = " + me2.su2);
		System.out.println("main su2 = " + me.su2);
	}

	public void func02() {
		su2++;
		System.out.println("f2 su2 = " + su2);
	}

	public static void func01(int su1) {
		su1++;
		System.out.println("func01 su1 = " + su1);
	}
}
