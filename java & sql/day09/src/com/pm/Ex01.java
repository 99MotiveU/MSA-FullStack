package com.pm;

public class Ex01 {
//	static com.am.Ex07 ex07;

	public static void main(String[] args) {
		System.out.println("시작");
//		System.exit(0);
		long beforeTime = System.currentTimeMillis();
		long beforeNano = System.nanoTime();
//		java.io.PrintStream myOut=System.out;
//		myOut.println();
//		String msg=Ex01.ex07.toString();
		char[] arr1 = new char[] { 'a', 'b', 'c' };
		char[] arr2 = new char[3];
		System.arraycopy(arr1, 0, arr2, 0, 3);
		arr1[1] = 'B';

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
//		System.console().printf("aaaa", new Object[] {});
		String msg = "msg";
		for (int i = 0; i < 10000; i++) {
			msg += i;
		}
		long afterTime = System.currentTimeMillis();
		long afterNano = System.nanoTime();
		System.out.print(afterTime - beforeTime);
		System.out.println(afterNano - beforeNano);
		
		System.out.println("a"+System.lineSeparator()+"b");
		// 운영체제에 따라 다를 수 있
		System.out.println("a\r\nb");
		System.out.println("a\nb");
		System.out.println(System.getenv()); //환경변수
		
		System.out.println(msg);
	}

}
