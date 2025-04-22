package com.pm;

public class Ex08 {

	public static void main(String[] args) {
		// compareTo(String anotherString)
		// compareToIgnoreCase(String str)
		//얼마나 다른지 어느게 얼마나 더 긴지 알 수 있음
//		String msg1 = "java";
//		String msg2 = "java12";
		
		String msg1 = "javdsdfasdf";//뒤의 길이는 상관 없음
		String msg2 = "java";
		System.out.println(msg1.compareTo(msg2));

	}

}
